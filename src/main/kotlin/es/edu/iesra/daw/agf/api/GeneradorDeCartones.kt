package es.edu.iesra.daw.agf.api

object GeneradorDeCartones  {

    /**
     * Genera los cartones indicados por **cuantos**
     */
    fun genera(cuantos: Int): List<Carton> {
        //TODO: Para hacerlo generico, se tendría que indicar el número de filas, columnas. Y calcular el rango de
        // numeros de cada columna y cuantos numeros tiene que proporcionar columna
        return List<Carton>(cuantos){
            Carton( it.toString(),
                listOf(
                    ServicioNumeros(1,16).siguientesNumeros(4),
                    ServicioNumeros(16,31).siguientesNumeros(4),
                    ServicioNumeros(31,46).siguientesNumeros(4),
                    ServicioNumeros(46,61).siguientesNumeros(4),
                    ServicioNumeros(61,76).siguientesNumeros(4)
                )
            )
        }
    }

}