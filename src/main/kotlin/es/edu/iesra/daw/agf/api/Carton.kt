package es.edu.iesra.daw.agf.api

class GeneradorDeCartones {

    private val numeroMaximo = 75
    private val numerosPorCarton = 15


    inner class Carton(val numeros: List<Int>) {
        private val carton = Array(5) { IntArray(5) }
        private var lineas = 0
        private var bingo = false
        private val columnas = arrayOf(IntArray(5) { i -> i * 15 + 1 },
            IntArray(5) { i -> i * 15 + 16 },
            IntArray(5) { i -> i * 15 + 31 },
            IntArray(5) { i -> i * 15 + 46 },
            IntArray(5) { i -> i * 15 + 61 })

        init {
            for (i in 0..4) {
                for (j in 0..4) {
                    carton[i][j] = 0
                }
            }
            rellenar()
        }

        private fun rellenar() {
            for (columna in columnas) {
                columna.shuffle()
                for (i in 0..2) {
                    carton[i][columnas.indexOf(columna)] = columna[i]
                }
            }
        }

        fun comprobarLinea(): Boolean {
            for (i in 0..4) {
                if (carton[i].sum() == 60) {
                    lineas++
                    return true
                }
                var suma = 0
                for (j in 0..4) {
                    suma += carton[j][i]
                }
                if (suma == 60) {
                    lineas++
                    return true
                }
            }
            var suma = 0
            for (i in 0..4) {
                suma += carton[i][i]
            }
            if (suma == 60) {
                lineas++
                return true
            }
            suma = 0
            for (i in 0..4) {
                suma += carton[i][4 - i]
            }
            if (suma == 60) {
                lineas++
                return true
            }
            return false
        }

        fun comprobarBingo(): Boolean {
            var suma = 0
            for (i in 0..4) {
                for (j in 0..4) {
                    suma += carton[i][j]
                }
            }
            if (suma == 60) {
                bingo = true
                return true
            }
            return false
        }

        fun marcar(numero: Int) {
            for (i in 0..4) {
                for (j in 0..4) {
                    if (carton[i][j] == numero) {
                        carton[i][j] = 0
                        return
                    }
                }
            }
        }


    }



    private fun generarUnCarton(): Carton {
        val numeros = (1..numeroMaximo).shuffled().take(numerosPorCarton).sorted()
        return Carton(numeros)
    }

    fun generarVariosCartones(cantidad: Int): List<Carton> {
        return (1..cantidad).map { generarUnCarton() }
    }

}
