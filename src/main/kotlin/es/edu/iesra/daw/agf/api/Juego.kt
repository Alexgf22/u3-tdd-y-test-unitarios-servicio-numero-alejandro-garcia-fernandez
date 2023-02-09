package es.edu.iesra.daw.agf.api

class Juego(private val numeroCartones: Int) {
    private val cartones = mutableListOf<Carton>()
    private val bombo = Bombo()

    init {
        for (i in 0..numeroCartones) {
            val carton: Carton = GeneradorDeCartones().generarUnCarton()
            cartones.add(carton)
        }
    }

    fun jugar() {
        while (cartones.none { it.comprobarBingo() }) {
            val numero = bombo.sacarBola()
            for (carton in cartones) {
                if (numero != null) {
                    carton.marcarNumero(numero)
                }
                if (carton.comprobarLinea()) {
                    println("Carton ${carton.id} ha ganado una línea")
                }
            }
        }
        val ganador = cartones.first { it.comprobarBingo() }
        println("Carton ${ganador.id} ha ganado el bingo")
    }

    fun obtenerResumen() {
        for (carton in cartones) {
            println("Carton ${carton.id}: Líneas ganadas ${carton.comprobarLinea()}, Bingo: ${carton.comprobarBingo()}")
        }
    }
}
