package es.edu.iesra.daw.agf.api

class GeneradorDeCartones {

    private val numeroMaximo = 75
    private val numerosPorCarton = 20


    inner class Carton(numeros: List<Int>) {
        internal val id: Int = 0
        private val carton = Array(5) { IntArray(5) }
        private var numerosMarcados = mutableListOf<Int>()
        private var lineas = 0
        private var bingo = false
        //private val columnas : MutableList<Int> = mutableListOf()

        init {

            rellenar()
        }

        private fun rellenar() {
            for (fila in 0..4) {
                for (columna in 0..4) {

                    when (fila) {
                        0 -> if (columna == 0) {
                            carton[fila][columna] = 0
                        } else {
                            val rangoNumeros = ServicioNumeros(1, 16)
                            carton[fila][columna] = rangoNumeros.dameUnNumero()!!
                        }

                        1 -> if (columna == 1) {
                            carton[fila][columna] = 0
                        } else {
                            val rangoNumeros = ServicioNumeros(16, 31)
                            carton[fila][columna] = rangoNumeros.dameUnNumero()!!
                        }

                        2 -> if (columna == 2) {
                            carton[fila][columna] = 0
                        } else {
                            val rangoNumeros = ServicioNumeros(31, 46)
                            carton[fila][columna] = rangoNumeros.dameUnNumero()!!
                        }

                        3 -> if (columna == 3) {
                            carton[fila][columna] = 0
                        } else {
                            val rangoNumeros = ServicioNumeros(46, 61)
                            carton[fila][columna] = rangoNumeros.dameUnNumero()!!
                        }

                        4 -> if (columna == 4) {
                            carton[fila][columna] = 0
                        } else {
                            val rangoNumeros = ServicioNumeros(61, 76)
                            carton[fila][columna] = rangoNumeros.dameUnNumero()!!
                        }


                    }


                }
            }


        }

        fun marcarNumero(numero: Int) {


        }

        fun comprobarLinea(): Boolean {

        }

        fun comprobarBingo(): Boolean {

        }

        fun marcar(numero: Int) {
            for (i in 0..4) {
                for (j in 0..4) {
                    if (carton[i][j] == numero) {
                        carton[i][j] = -1
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
