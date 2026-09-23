package control_flujo

fun ejercicio1(n1: Int, n2: Int) {
    /*  1. Realizar el almacenamiento de dos números enteros solicitado por teclado e
           imprimir su suma y su producto de los números tecleados. */
    println("La suma de $n1 + $n2 es ${n1 + n2}")
    println("El producto de $n1 * $n2 es ${n1 * n2}")
}

fun ejercicio1_1(n1: Int, n2: Int) = println("La suma de $n1 + $n2 es ${n1 + n2}, \nel producto de $n1 * $n2 es ${n1 * n2}")

fun ejercicio1_2(){
    print("Ingrese el numero 1: ")
    val n1: Int = readlnOrNull()?.toIntOrNull() ?: 0
    print("Ingrese el numero 2: ")
    val n2: Int = readlnOrNull()?.toIntOrNull() ?: 0
    println("La suma de $n1 + $n2 es: ${n1 + n2} \nEl producto de $n1 * $n2 es: ${n1 * n2}")
}

fun ejercicio2(lado: Float) {
    /*  2. Calcule el lado de un cuadrado, mostrar por pantalla el área del mismo
           (El perímetro de un cuadrado se calcula multiplicando el valor del lado por cuatro) */
    println("El area del cuadrado es ${lado * 4}")

}

fun ejercicio2_1(lado: Float) = println("El área del cuadrado es ${lado * 4}")

fun ejercicio3(precio: Float, cantidad: Int) {
    /*  3. Se debe desarrollar un programa que solicite el ingreso del precio de un artículo y
        la cantidad. Mostrar lo que debe abonar el comprador. */
    println("Debe abonar ${precio * cantidad}")
}