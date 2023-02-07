package es.edu.iesra.daw.agf.api

class Juego {

    private var cartones: MutableList<GeneradorDeCartones.Carton> = mutableListOf()

    private var bombo = Locutor.Bombo()

    fun agregarCarton(carton: GeneradorDeCartones.Carton) {
        cartones.add(carton)
    }


    fun play() {

    }

    fun comprobarLinea() {



    }



    fun comprobarBingo() {
        for (carton in cartones) {
            if (carton.comprobarBingo()) {
                println("BINGO en el cartón de ${carton.id}")
            }
        }
    }


    override fun toString(): String {
        return super.toString()
    }





}