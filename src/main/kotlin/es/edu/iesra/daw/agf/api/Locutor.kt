package es.edu.iesra.daw.agf.api

class Locutor() {

    private val bombo = Bombo()

    fun cantarBolas() {
        val numeros: MutableList<Int> = mutableListOf()

        for (i in 1..75) {
            val bola = bombo.sacarBola()
            if (bola != null) {
                numeros.add(bola)
            }
            println("Ha salido la bola número $bola")
        }
    }


}



