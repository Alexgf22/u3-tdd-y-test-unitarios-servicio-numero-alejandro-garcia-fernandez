package es.edu.iesra.daw.agf.api



/*
Los locutores de bingo supervisan las partidas de bingo que se juegan en los clubes de bingo.
Llaman a los números hasta que se produce un ganador.
 */
object Locutor{
    val nuevoNumero = Signal<Int>()
    lateinit var bombo:Bombo

    /**
     * Configura el objeto
     */
    fun configura(bombo:Bombo = Bombo ){
        this.bombo = bombo
    }

    /**
     * Saca nueva bola y anuncia el numero
     */
    fun anunciaNuevaBola():Boolean{
        var hayBolas = false
        bombo.dameNuevaBola()?.let{
            nuevoNumero.emitir(it)
            hayBolas = true
        }
        return hayBolas
    }


}



