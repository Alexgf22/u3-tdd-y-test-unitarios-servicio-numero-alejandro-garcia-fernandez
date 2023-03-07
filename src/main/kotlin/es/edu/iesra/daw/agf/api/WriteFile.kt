package es.edu.iesra.daw.agf.api

import java.io.File
import java.io.FileWriter
import java.time.LocalDateTime

class WriteFile {

    fun write() {

        val datetime = LocalDateTime.now()

        val logFile = File(".bingo/out/${datetime}.log")
        val writer = FileWriter(logFile)

        // Escribir los números que han salido del bombo

        //writer.write("Numeros: ${numeros.joinToString(", ")}\n")

        // Escribir las líneas que se han cantado

        /*for ((linea, carton) in registro.lineaCantada().withIndex()) {
            writer.write("Linea $linea: Carton $carton\n")
        }*/

        // Escribir el bingo cantado

        /*if (bingoCantado() != null) {
            writer.write("Bingo: Carton ${bingo}\n")
        }*/

        writer.close()

    }

}