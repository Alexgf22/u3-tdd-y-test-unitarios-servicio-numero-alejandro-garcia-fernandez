package es.edu.iesra.daw.agf.api

class Bombo() {

    fun sacarBola(): Int? {
        val rangoNumeros = ServicioNumeros(1, 76)

        return rangoNumeros.dameUnNumero()
    }

}