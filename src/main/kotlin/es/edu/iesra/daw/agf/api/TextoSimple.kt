package es.edu.iesra.daw.agf.api

class FormatoTexto : OutputFormatter {
    override fun imprimir(numeros: List<Int>): String {
        val sb = StringBuilder()
        sb.append("Números cantados: ")
        sb.append(numeros.joinToString(", "))
        sb.append("\n")
        sb.append("Cartones:\n")
        Juego.cartones.forEach { carton ->
            sb.append(carton)
            sb.append("\n")
        }
        return sb.toString()
    }
}





