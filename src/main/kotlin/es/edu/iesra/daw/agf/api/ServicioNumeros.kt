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
    private var numeros: MutableList<Int> = mutableListOf()
    val rangoNumeros = minimo until maximo
    val limiteLista = maximo - minimo

    fun dameNumero(): Int {
        val numeroAleatorio = rangoNumeros.random()
        var numeroResultante = 0
        if(!comprobarCantidadNumeros(numeroAleatorio)) {
            numeroResultante += numeroAleatorio
        }
        return numeroResultante
    }

    fun comprobarCantidadNumeros(numeroAleatorio: Int): Boolean {
        var excedidoLimite = false
        if((numeroAleatorio !in numeros) && (numeros.size < limiteLista)) {
            numeros.add(numeroAleatorio)
        }
        else {
            excedidoLimite = true
        }
        return excedidoLimite

    }

}


fun main() {
    val servicioNum1 = ServicioNumeros(1,10)

    val numeroAleatorio = servicioNum1.dameNumero()

    println(numeroAleatorio)
}
