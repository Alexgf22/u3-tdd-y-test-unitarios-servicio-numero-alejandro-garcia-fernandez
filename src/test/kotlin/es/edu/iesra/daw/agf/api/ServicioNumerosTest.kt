package es.edu.iesra.daw.agf.api

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.should

class ServicioNumerosTest : DescribeSpec({

    describe("Inicializo la clase") {
        val randomNumbers = ServicioNumeros(1, 10)

        it("Devolverá un número aleatorio entre min y max") {
            randomNumbers.dameNumero().should { 1..10 }
        }
    }

})
