package es.edu.iesra.daw.agf.api

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.string.shouldStartWith

class ServicioNumerosTest : DescribeSpec({

    describe("Cuando máximo es igual a mínimo o menor") {
        it("En este caso lanza un error de parámetros ilegales") {
        val maximo = 8
        val minimo = 8
        val excepcion = shouldThrowExactly<IllegalArgumentException> {
            ServicioNumeros(minimo, maximo)
        }
        excepcion.message.shouldStartWith("El parámetro máximo")
    }
    it("En este caso donde el máximo es menor que mínimo, lanza un error de parámetros ilegales") {
        val maximo = 2
        val minimo = 3
        val excepcion = shouldThrowExactly<IllegalArgumentException> {
            ServicioNumeros(minimo, maximo)
        }
        excepcion.message.shouldStartWith("El parámetro máximo")
    }
}


    describe("Cuando hay una diferencia de solamente 1 entre max y min") {
        val minimo = 6
        val maximo = 7
        val servicio = ServicioNumeros(minimo, maximo)
        it("El servicio solo contiene el valor mínimo") {
            servicio.dameUnNumero()?.shouldBeExactly(minimo)
        }
        it("El servicio quedaría vacío, al sacar el primer y único número") {
            servicio.restoNumeros().size.shouldBeExactly(0)
        }
    }

    /*describe("Una vez inicializado, por segunda vez") {
        servicio.inicializa()
        it("El servicio contiene únicamente el valor mínimo") {
            servicio.dameUnNumero()?.shouldBeExactly(minimo)
        }

        it("El segundo valor debe ser nulo") {
            servicio.dameUnNumero()?.let {
                it.shouldBeNull()
            }
        }
    }*/



    describe("Con una diferencia de 2 entre máximo y mínimo") {
        val minimo = 5
        val maximo = 7
        val servicio = ServicioNumeros(minimo, maximo)
        it("El servicio debe contener los elementos {minimo , maximo -1}") {
            servicio.restoNumeros().shouldContainAll(minimo, maximo -1)
        }
    }

    describe("Debe devolver números") {
        it("Todos los números entre mínimo y máximo") {
            val minimo = 1
            val maximo = 1550
            val servicio = ServicioNumeros(minimo, maximo)
            servicio.restoNumeros().shouldContainExactlyInAnyOrder(List(maximo - minimo) {minimo + it})
        }
    }

})
