package es.edu.iesra.daw.agf.api

class GeneradorDeCartones {

    private val numeroMaximo = 75
    private val numerosPorCarton = 20



    private val cartonesId: MutableList<Int> = mutableListOf()
    private fun generarUnCarton(): Carton {
        val id = (1..999).random()
        lateinit var carton: Carton
        if(id !in cartonesId) {
            cartonesId.add(id)
            carton = Carton(id)
        }
        return carton

    }

    fun generarVariosCartones(cantidad: Int): List<Carton> {
        return (1..cantidad).map { generarUnCarton() }
    }

}