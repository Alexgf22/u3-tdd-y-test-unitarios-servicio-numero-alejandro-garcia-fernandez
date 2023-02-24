package es.edu.iesra.daw.agf.api


object Bombo {

    private lateinit var servicioNumeros: ServicioNumeros
    init {
        configura()
    }
    fun configura(servicioNumeros: ServicioNumeros = ServicioNumeros(1,76)) {
        this.servicioNumeros = servicioNumeros
    }

    fun dameNuevaBola(): Int? {
        return servicioNumeros.dameUnNumero()
    }

}