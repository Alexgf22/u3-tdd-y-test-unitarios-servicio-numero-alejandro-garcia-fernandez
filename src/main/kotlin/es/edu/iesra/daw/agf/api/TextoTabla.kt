package es.edu.iesra.daw.agf.api

class FormatoTabla : OutputFormatter {
    /**
     * Toma como parámetros la lista de cartones del juego y el último número anunciado por el locutor.
     * Devuelve una cadena de caracteres que representa el juego de bingo en formato de tabla, con una
     * cabecera, un separador y el cuerpo de la tabla con los números marcados en los cartones.
     * Cada columna se ajusta a la longitud máxima del número en esa columna.
     */
    override fun imprimir(numeros: List<Int>): String {

        //val ultimaBola : Int = 0
        val tabla = StringBuilder()

        //tabla.appendLine("Último número anunciado: ${(cartones[-1])}")

        // Agregar los encabezados de las columnas de la tabla
        tabla.appendLine("| B | I | N | G | O |")

        // Recorrer todos los cartones en la lista
        Juego.cartones.forEach { carton ->
            // Agregar una línea en blanco antes de cada cartón
            tabla.appendLine()

            // Recorrer cada fila del cartón
            // for fila in carton.numeros
            /*for (fila in carton) {
                tabla.append("|")
                // Recorrer cada número en la fila
                // for numero in fila
                for (numero in 0..4) {
                    if (numero == 0) {
                        tabla.append("   ")
                    } else {
                        tabla.append(" $numero ")
                    }
                    tabla.append("|")
                }
                tabla.appendLine()

            }*/
        }

        // Agregar una línea en blanco al final de la tabla
        tabla.appendLine()

        return tabla.toString()
    }
}