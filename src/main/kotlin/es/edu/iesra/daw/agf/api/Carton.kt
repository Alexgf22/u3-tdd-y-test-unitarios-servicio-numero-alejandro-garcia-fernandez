package es.edu.iesra.daw.agf.api

class Carton(val id: Int) {
    val carton = Array(5) { IntArray(5) }
    var lineas = 0
    var bingo = false
    val columnas = arrayOf(IntArray(5) { i -> i * 15 + 1 },
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
        fill()
    }

    private fun fill() {
        for (col in columnas) {
            col.shuffle()
            for (i in 0..2) {
                carton[i][columnas.indexOf(col)] = col[i]
            }
        }
    }

    fun checkLine(): Boolean {
        for (i in 0..4) {
            if (carton[i].sum() == 60) {
                lineas++
                return true
            }
            var sum = 0
            for (j in 0..4) {
                sum += carton[j][i]
            }
            if (sum == 60) {
                lineas++
                return true
            }
        }
        var sum = 0
        for (i in 0..4) {
            sum += carton[i][i]
        }
        if (sum == 60) {
            lineas++
            return true
        }
        sum = 0
        for (i in 0..4) {
            sum += carton[i][4 - i]
        }
        if (sum == 60) {
            lineas++
            return true
        }
        return false
    }

    fun checkBingo(): Boolean {
        var sum = 0
        for (i in 0..4) {
            for (j in 0..4) {
                sum += carton[i][j]
            }
        }
        if (sum == 60) {
            bingo = true
            return true
        }
        return false
    }

    fun mark(number: Int) {
        for (i in 0..4) {
            for (j in 0..4) {
                if (carton[i][j] == number) {
                    carton[i][j] = 0
                    return
                }
            }
        }
    }
}
