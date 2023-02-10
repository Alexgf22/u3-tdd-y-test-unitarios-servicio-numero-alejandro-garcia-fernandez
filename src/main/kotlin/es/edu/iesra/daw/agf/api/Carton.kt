package es.edu.iesra.daw.agf.api



class Carton(val id: Int) {
    private val carton = Array(5) { IntArray(5) }
    private var numerosMarcados = mutableListOf<Int>()
    private var lineas = 0
    private var bingo = false
    private var numerosSalidos = Array(5) {IntArray(5)}

    init {
        rellenar()
    }

    private fun rellenar() {
        for (fila in carton.indices) {
            for (columna in 0 until carton[0].size) {

                when (columna) {
                    0 -> if (fila == 0) {
                        carton[fila][columna] = 0
                    } else {
                        val rangoNumeros = ServicioNumeros(1, 16)
                        carton[fila][columna] = rangoNumeros.dameUnNumero()!!
                    }

                    1 -> if (fila == 1) {
                        carton[fila][columna] = 0
                    } else {
                        val rangoNumeros = ServicioNumeros(16, 31)
                        carton[fila][columna] = rangoNumeros.dameUnNumero()!!
                    }

                    2 -> if (fila == 2) {
                        carton[fila][columna] = 0
                    } else {
                        val rangoNumeros = ServicioNumeros(31, 46)
                        carton[fila][columna] = rangoNumeros.dameUnNumero()!!
                    }

                    3 -> if (fila == 3) {
                        carton[fila][columna] = 0
                    } else {
                        val rangoNumeros = ServicioNumeros(46, 61)
                        carton[fila][columna] = rangoNumeros.dameUnNumero()!!
                    }

                    4 -> if (fila == 4) {
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
                    numerosMarcados.add(carton[fila][columna])
                    numerosSalidos[fila][columna] = numero
                    carton[fila][columna] = -1
                }
            }
        }

    }


    // Comprobar lineas horizontales
    private val filasHorizontalesHechas = mutableListOf(0,0,0,0,0)

    // Comprobar lineas verticales
    private val filasVerticalesHechas = mutableListOf(0,0,0,0,0)

    // Comprobar lineas diagonales
    private val filasDiagonalesHechas = mutableListOf(0,0,0,0,0)

    fun comprobarLinea(): Boolean {

        var esLinea = false


        for (fila in 0..4) {

            // Lineas horizontales
            if (carton[fila].sum() == -4 && filasHorizontalesHechas[fila] == 0) {
                lineas++
                filasHorizontalesHechas[fila] = 1
                esLinea = true
            }


            // Lineas verticales
            var suma = 0
            for (columna in 0..4) {
                suma += carton[columna][fila]

                if (suma == -4 && filasVerticalesHechas[columna] == 0) {
                    lineas++
                    filasVerticalesHechas[columna] = 1
                    esLinea = true

                }
            }

        }


        // Lineas diagonales

        /*
        Coordenadas de inicio diagonales:
        Primera coordenada es la fila y la segunda coordenada es la columna
        (1,0) ; (0,1) ; (0,3) ; (1,4) ; (0,4)
         */

        var sumaPrimeraDiagonal = 0

        val primeraDiagonal = intArrayOf(1,0)
        for(i in 0..3) {
            if(i != 0) {
                primeraDiagonal[0] += 1
                primeraDiagonal[1] += 1
                sumaPrimeraDiagonal += carton[primeraDiagonal[0]][primeraDiagonal[1]]
            }

            if(sumaPrimeraDiagonal == -4 && filasDiagonalesHechas[0] == 0) {
                lineas++
                filasDiagonalesHechas[0] = 1
                esLinea = true
            }
        }


        var sumaSegundaDiagonal = 0

        val segundaDiagonal = intArrayOf(0,1)
        for(i in 0..3) {
            if(i != 0) {
                segundaDiagonal[0] += 1
                segundaDiagonal[1] += 1
                sumaSegundaDiagonal += carton[segundaDiagonal[0]][segundaDiagonal[1]]
            }

            if(sumaSegundaDiagonal == -4 && filasDiagonalesHechas[1] == 0) {
                lineas++
                filasDiagonalesHechas[1] = 1
                esLinea = true
            }
        }


        var sumaTerceraDiagonal = 0

        val terceraDiagonal = intArrayOf(0,3)
        for(i in 0..3) {
            if(i != 0) {
                terceraDiagonal[0] += 1
                terceraDiagonal[1] -= 1
                sumaTerceraDiagonal += carton[terceraDiagonal[0]][terceraDiagonal[1]]
            }

            if(sumaTerceraDiagonal == -4 && filasDiagonalesHechas[2] == 0) {
                lineas++
                filasDiagonalesHechas[2] = 1
                esLinea = true
            }
        }


        var sumaCuartaDiagonal = 0

        val cuartaDiagonal = intArrayOf(1,4)
        for(i in 0..3) {
            if(i != 0) {
                cuartaDiagonal[0] += 1
                cuartaDiagonal[1] -= 1
                sumaCuartaDiagonal += carton[cuartaDiagonal[0]][cuartaDiagonal[1]]
            }

            if(sumaCuartaDiagonal == -4 && filasDiagonalesHechas[3] == 0) {
                lineas++
                filasDiagonalesHechas[3] = 1
                esLinea = true
            }
        }


        var sumaQuintaDiagonal = 0

        val quintaDiagonal = intArrayOf(0,4)
        for(i in 0..4) {
            if(i != 0 && i != 2) {
                quintaDiagonal[0] += 1
                quintaDiagonal[1] -= 1
                sumaQuintaDiagonal += carton[quintaDiagonal[0]][quintaDiagonal[1]]

            }

            if(sumaQuintaDiagonal == -4 && filasDiagonalesHechas[4] == 0) {
                lineas++
                filasDiagonalesHechas[4] = 1
                esLinea = true
            }
        }

        return esLinea


    }



    fun comprobarBingo(): Boolean {

        if(filasHorizontalesHechas.sum() == 5) {
            bingo = true
        }
        return bingo

    }



    }






