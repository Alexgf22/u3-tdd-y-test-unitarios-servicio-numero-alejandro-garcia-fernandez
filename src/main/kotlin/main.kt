import es.edu.iesra.daw.agf.api.Juego
import java.io.File

fun main() {
    /*
    En primer lugar, comprobamos si el directorio principal llamado (.bingo) existe y si no existe lo creamos.
    Después, creamos los directorios (config) y (out) dentro del directorio (.bingo)
    Una vez hecho lo anterior, creamos ahora el archivo de configuración (bingo.conf) dentro
    del directorio (config) en caso de que no exista.

    Luego, comprobamos si el directorio (out) existe y creamos el directorio (20230221) dentro de él si no
    existe. En último lugar, creamos el archivo de registro (20230222092453.log) dentro del directorio (20230221)
    si no existe.
    */

    val bingoDir = File(".bingo")
    if (!bingoDir.exists()) {
        bingoDir.mkdir()
        val configDir = File(bingoDir, "config")
        configDir.mkdir()
        val outDir = File(bingoDir, "out")
        outDir.mkdir()
    }
    val archivoConfig = File(bingoDir, "config/bingo.conf")
    if (!archivoConfig.exists()) {
        archivoConfig.createNewFile()
    }
    val outDir = File(bingoDir, "out")
    val fechaDir = File(outDir, "20230221")
    if (!fechaDir.exists()) {
        fechaDir.mkdir()
    }
    val archivoRegistro = File(fechaDir, "20230222092453.log")
    if (!archivoRegistro.exists()) {
        archivoRegistro.createNewFile()
    }

    // Configuración del juego
    Juego.configura()
    Juego.play()


}

