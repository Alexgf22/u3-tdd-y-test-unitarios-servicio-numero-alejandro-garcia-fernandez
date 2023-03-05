package es.edu.iesra.daw.agf.api

interface OutputFormatter {
    fun imprimir(numeros: List<Int>): String
}