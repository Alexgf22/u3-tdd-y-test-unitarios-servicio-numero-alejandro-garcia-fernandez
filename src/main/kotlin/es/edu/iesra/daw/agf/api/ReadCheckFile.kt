package es.edu.iesra.daw.agf.api

import java.io.File
import java.io.FileInputStream
import java.util.*

class ReadCheckFile {

    fun readAndCheck(args: Array<String>) {
        // Lectura de la configuración
        val configFile = File(".bingo/config/bingo.conf")
        val configProps = Properties()

        // Verificar si existe el archivo y cargar las propiedades
        if (configFile.exists()) {
            configProps.load(FileInputStream(configFile))
        } else {
            println("No se ha encontrado el fichero de configuración o el fichero es erróneo")
        }

        // Verificar si se ha pasado la configuración por línea de comandos y sobrescribir si es necesario
        if (args.isNotEmpty()) {
            for (arg in args) {
                if (arg.startsWith("numCartones=")) {
                    configProps.setProperty("numCartones", arg.substringAfter("="))
                } else if (arg == "salida=ts") {
                    configProps.setProperty("salida", "ts")
                } else if (arg == "salida=tt") {
                    configProps.setProperty("salida", "tt")
                } else if (arg == "resumen=S") {
                    configProps.setProperty("resumen", "S")
                } else if (arg == "resumen=N") {
                    configProps.setProperty("resumen", "N")
                }
            }
        }

        val numCartones = configProps.getProperty("numCartones")?.toInt() ?: 1
        val modoSalida = configProps.getProperty("salida") ?: "ts"
        val mostrarResumen = configProps.getProperty("resumen") == "S"




    }

}