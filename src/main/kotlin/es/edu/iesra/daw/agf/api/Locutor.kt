package es.edu.iesra.daw.agf.api

class Locutor() {

    class Bombo() {

        fun sacarBola(): Int? {
            val rangoNumeros = ServicioNumeros(1, 76)

            return rangoNumeros.dameUnNumero()
        }

    }


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



