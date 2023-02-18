package es.edu.iesra.daw.agf.api

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.nulls.shouldBeNull
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

/*
El bombo expulsará una bola marcada con un número entre 1 y 75
que previamente no se ha generado anteriormente.
 */
class BomboTest : DescribeSpec({
    // Aunque no sería necesario crear un mock, ya que para los test nos servirían
    // que los numeros puedieran ser aleatorios, se realiza a modo de ejemplo.
    describe("Un bombo de un bingo"){

        val bombo = Bombo

        val maximo = 8
        val minimo = 1

        // Creo una lista con los elementos ordenados de forma aleatoria
        val listaMock = List(maximo - minimo) {
            minimo + it
        }.shuffled()

        //El resto de metodos no los usaré, por tanto uso el modo relajado
        val servicioNumeroMock = mockk<ServicioNumeros>(relaxed = true)
        // Le digo que cada vez que se llame al objeto y metodo, devuelva un elemento de la lista.
        // Además, añado el elemento null al final, para que sea ese el que se devuelve si se hace
        // la invocación maximo + 1
        every { servicioNumeroMock.dameUnNumero() } returnsMany MutableList<Int?>(maximo - minimo) {
            minimo + it
        }.also{
            it.shuffled()
            it.add(null)
        }
        // Inyecto el servicio de numeros Mock
        bombo.configura(servicioNumeroMock)
        it("Debe generar numeros aleatorios entre minimo y maximo") {
            // Hago (maximo - minimo) invocaciones al metodo y introduzco los elementos en la lista
            val lista = List(maximo - minimo) {
                bombo.nuevaBola()
            }
            lista.shouldContainExactlyInAnyOrder(listaMock)
        }

        // En la invocación (maximo - minimo)+1, debe devolver nulo
        /*it("En la petición (maximo - minimo)+1, debe devolver null") {
            bombo.sacarBola().shouldBeNull()
            verify(exactly=(maximo - minimo)+1) { servicioNumeroMock.unNumeroOrNull()}
        }*/

    }
})