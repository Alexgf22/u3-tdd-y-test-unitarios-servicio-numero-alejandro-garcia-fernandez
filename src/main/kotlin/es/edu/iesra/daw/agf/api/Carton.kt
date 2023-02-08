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
            for (fila in 0..4) {
                for (columna in 0..4) {
                    if (carton[fila][columna] == numero) {
                        carton[fila][columna] = -1
                    }
                }
            }

        }

        fun comprobarLinea() {



            // Comprobar lineas horizontales
            val filasHorizontalesHechas = mutableListOf(0,0,0,0,0)

            // Comprobar lineas verticales
            val filasVerticalesHechas = mutableListOf(0,0,0,0,0)

            for (fila in 0..4) {
                // Lineas horizontales
                if (carton[fila].sum() == -4 && filasHorizontalesHechas[fila] == 0) {
                    lineas++
                    filasHorizontalesHechas[fila] = 1
                }


                // Lineas verticales
                var suma = 0
                for (columna in 0..4) {
                    suma += carton[columna][fila]

                    if (suma == -4 && filasVerticalesHechas[columna] == 0) {
                        lineas++
                        filasVerticalesHechas[columna] = 1

                    }
                }

            }


            // Lineas diagonales



        }



        fun comprobarBingo(): Boolean {

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
