package es.edu.iesra.daw.agf.api

class Locutor() {

    private val bombo = Bombo()

    private class Bombo() {

        private val numeros: MutableList<Int> = mutableListOf()

        fun sacarBola(): Int? {
            val rangoNumeros = ServicioNumeros(1, 76)
            val numeroAleatorio = rangoNumeros.dameUnNumero()
            if (numeroAleatorio != null) {
                numeros.add(numeroAleatorio)
            }
            return numeroAleatorio
        }

        fun quedanBolas(): Boolean = numeros.isNotEmpty()
    }

    //fun cantaBolas()


}
