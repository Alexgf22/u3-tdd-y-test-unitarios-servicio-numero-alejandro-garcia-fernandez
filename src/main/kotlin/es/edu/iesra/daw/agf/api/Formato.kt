package es.edu.iesra.daw.agf.api

interface OutputFormatter {
    fun format(registro: Registro): String
}