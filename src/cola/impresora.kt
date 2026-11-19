package cola

data class Trabajo(val id : Int, val usuario : String, val nombre : String, val n_pag : Int){

}

class Impresora () {
    var lista = mutableListOf<Trabajo>()

    fun detalles(trabajo: Trabajo){
        print(trabajo)
    }

    fun enviar(trabajo: Trabajo){
        if (lista.contains(trabajo)) {
            print("El trabajo ya estaba en la cola")
        }else{
            lista.add(trabajo)
            print("Trabajo ${detalles(trabajo)} añadido correctamente.")
        }

    }

    fun imprimirSiguiente() {
        if (lista.isEmpty()) {
            print(null)
        } else {
            print("Imprimiendo: ${lista.first()}")
            lista.removeFirst()
        }
    }

    fun verSiguiente() {
        if (lista.isEmpty()) {
            print(null)
        } else {
            print(lista.first())
        }
    }

}