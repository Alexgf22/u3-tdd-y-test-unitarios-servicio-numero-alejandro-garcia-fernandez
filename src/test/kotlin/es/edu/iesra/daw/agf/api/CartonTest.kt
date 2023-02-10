package es.edu.iesra.daw.agf.api

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CartonTest : DescribeSpec( {


    describe("..............") {
        it(".............") {
            val carton = Carton(5)

            carton.comprobarTamano().shouldBe(arrayOf(intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0)))

        }
    }



})