package es.edu.iesra.daw.agf.api

/*
    - Se podrá solicitar de uno en uno, siguiendo las normas anteriores.

    - Se podrá solicitar el resto de números que quedan hasta el total,
      devolviendo una lista con esos números en orden aleatorio.

    - Se podrá solicitar que el servicio devuelva una lista de N números.
      Si N es mayor que el número de números que quedan por servir, funcionará
      como si se solicitara el resto de números.
 */
class ServicioNumeros(minimo: Int, maximo: Int) {

    private lateinit var fuenteNumeros: MutableList<Int>
    private val listaNumeros: List<Int> by lazy {
        List(maximo - minimo) {
            minimo + it
        }
    }

    init {
        require(maximo > minimo) {"El parámetro máximo tiene que ser mayor que el mínimo"}
        inicializa()
    }


    fun inicializa() {
        fuenteNumeros = listaNumeros.shuffled().toMutableList()
    }

    fun dameUnNumero(): Int? = fuenteNumeros.removeFirstOrNull()


    fun siguientesNumeros(cantidadNumeros:Int): MutableList<Int> {
        lateinit var siguientesNumeros: MutableList<Int>
        if (cantidadNumeros >= fuenteNumeros.size) {
            siguientesNumeros = restoNumeros()
        }
        else {
            val tamanoLista = fuenteNumeros.size
            siguientesNumeros = fuenteNumeros.take(cantidadNumeros).toMutableList()
            fuenteNumeros = fuenteNumeros.takeLast(tamanoLista-cantidadNumeros).toMutableList()
    }
    return siguientesNumeros
}


    fun restoNumeros(): MutableList<Int> {
        val restoDeNumeros = fuenteNumeros.toMutableList()
        fuenteNumeros.clear()
        return restoDeNumeros
    }






}


fun main() {
    val servicioNum1 = ServicioNumeros(1,10)

    val numeroAleatorio = servicioNum1.dameUnNumero()
    val numeroAleatorio2 = servicioNum1.dameUnNumero()

    val siguientesNum = servicioNum1.siguientesNumeros(5)

    val restantes = servicioNum1.restoNumeros()

    println(numeroAleatorio)
    println(numeroAleatorio2)
    println(siguientesNum)
    println(restantes)
}
