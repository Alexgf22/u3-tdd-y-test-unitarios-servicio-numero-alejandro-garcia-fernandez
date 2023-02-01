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
    var numeros: MutableList<Int> = mutableListOf()
    val rangoNumeros = minimo until maximo
    val limiteLista = maximo - minimo
    var numeroAleatorio = rangoNumeros.random()

    fun dameUnNumero(): Int {
        if(!comprobarCantidadNumeros(numeroAleatorio) && numeroAleatorio !in numeros) {
            numeros.add(numeroAleatorio)
        }
        else if(!comprobarCantidadNumeros(numeroAleatorio) && numeroAleatorio in numeros) {
            numeroAleatorio = rangoNumeros.random()
        }
        return numeroAleatorio
    }

    fun dameNumerosRestantes(): MutableList<Int> {
        val numerosRestantes: MutableList<Int> = mutableListOf()

        for(i in numeros.size.. limiteLista) {
            numeroAleatorio = rangoNumeros.random()

            if(!comprobarCantidadNumeros(numeroAleatorio) && (numeroAleatorio !in numerosRestantes) && (numeroAleatorio !in numeros)) {
                numerosRestantes.add(numeroAleatorio)
            }

            else if(numeroAleatorio in numerosRestantes) {
                while((numeroAleatorio in numerosRestantes) && (!comprobarCantidadNumeros(numeroAleatorio))) {
                    numeroAleatorio = rangoNumeros.random()
                }
                /* Cuando comprueba en el bucle que númeroAleatorio no esté en númerosRestantes y no esté
                   en números pedidos, lo añade a la lista de numerosRestantes.
                 */
                numerosRestantes.add(numeroAleatorio)
            }
        }
        return numerosRestantes
    }




    fun comprobarCantidadNumeros(numeroAleatorio: Int): Boolean {
        var excedidoLimite = false
        if(numeros.size > limiteLista) {
            excedidoLimite = true
        }

        return excedidoLimite

    }

}


fun main() {
    val servicioNum1 = ServicioNumeros(1,10)

    val numeroAleatorio = servicioNum1.dameUnNumero()
    val numeroAleatorio2 = servicioNum1.dameUnNumero()

    val numerosRestantes = servicioNum1.dameNumerosRestantes()

    println(numeroAleatorio)
    println(numeroAleatorio2)
    println(numerosRestantes)
}
