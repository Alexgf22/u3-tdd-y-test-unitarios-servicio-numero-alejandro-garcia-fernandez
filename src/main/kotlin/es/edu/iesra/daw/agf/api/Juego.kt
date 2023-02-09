package es.edu.iesra.daw.agf.api

class Juego(private val numeroCartones: Int) {
    private val cartones = mutableListOf<GeneradorDeCartones.Carton>()
    private val bombo = Locutor.Bombo()

    init {
        for (i in 0 until numeroCartones) {
            cartones.add(GeneradorDeCartones.Carton(i + 1))
        }
    }

    fun jugar() {
        while (cartones.none { it.haGanado() }) {
            val numero = bombo.extraerBola()
            for (carton in cartones) {
                carton.marcarNumero(numero)
                if (carton.haGanadoLínea()) {
                    println("Carton ${carton.id} ha ganado una línea")
                }
            }
        }
        val ganador = cartones.first { it.haGanado() }
        println("Carton ${ganador.id} ha ganado el bingo")
    }

    fun obtenerResumen() {
        for (carton in cartones) {
            println("Carton ${carton.id}: Líneas ganadas ${carton.lineasGanadas()}, Bingo: ${carton.haGanado()}")
        }
    }
}
