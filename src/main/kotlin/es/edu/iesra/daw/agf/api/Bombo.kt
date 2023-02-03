package es.edu.iesra.daw.agf.api

class Bombo {
    private val numeros = (1..75).toMutableList()

    fun sacarBola(): Int {
        val index = (0 until numeros.size).random()
        val bola = numeros[index]
        numeros.removeAt(index)
        return bola
    }

    fun quedanBolas(): Boolean = numeros.isNotEmpty()
}
