package control_flujo

// Declaración de variables

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
    val precio = (readlnOrNull()?.toFloatOrNull() ?: 0.0f).coerceAtLeast(0F)
    val cantidad = (readlnOrNull()?.toIntOrNull() ?: 0).coerceAtLeast(0)

    println("Debe abonar ${precio * cantidad}")
}

fun ejercicio4(){
    print("Ingrese el numero 1: ")
    val n1: Int = readlnOrNull()?.toIntOrNull() ?: 0
    print("Ingrese el numero 2: ")
    val n2: Int = readlnOrNull()?.toIntOrNull() ?: 0
    print("Ingrese el numero 3: ")
    val n3: Int = readlnOrNull()?.toIntOrNull() ?: 0
    print("Ingrese el numero 4: ")
    val n4: Int = readlnOrNull()?.toIntOrNull() ?: 0
    println("La suma de $n1 + $n2 es: ${n1 + n2} \nEl producto de $n3 * $n4 es: ${n3 * n4}")
}

fun ejercicio5(){
    val numeros: MutableList<Int> = mutableListOf()
    for (x in 1..4){
        print("Ingrese el numero $x:")
        var entrada = (readlnOrNull()?.toIntOrNull() ?: 0).coerceIn(0,10)
        numeros.add(entrada)
    }
    println("La suma es: ${numeros.sum()} \nEl promedio es: ${numeros.average()}")
}

fun ejercicio5_1(){
    print("Ingrese el numero 1: ")
    val n1: Int = readlnOrNull()?.toIntOrNull() ?: 0
    print("Ingrese el numero 2: ")
    val n2: Int = readlnOrNull()?.toIntOrNull() ?: 0
    print("Ingrese el numero 3: ")
    val n3: Int = readlnOrNull()?.toIntOrNull() ?: 0
    print("Ingrese el numero 4: ")
    val n4: Int = readlnOrNull()?.toIntOrNull() ?: 0
    val suma: Int = n1 + n2 + n3 + n4
    val promedio: Float = suma.toFloat() / 4
    println("La suma de $n1 + $n2 + $n3 + $n4 es: $suma \nEl promedio de $n1 , $n2 , $n3 , $n4 , es: $promedio ")
}

// Estructuras de control (If-Else)

fun ejercicio6() {
    println("Ingrese el sueldo: ")
    if ((readlnOrNull()?.toIntOrNull() ?: 0) > 3000) println("Debe abonar impuestos")
}

fun ejercicio7() {
    // ealizar un programa que solicite ingresar dos números enteros distintos y muestre por pantalla el mayor de ellos.
    println("Ingrese un número entero: ")
    val n1 : Int = readlnOrNull()?.toIntOrNull()?:0
    println("Ingrese otro número entero: ")
    if (n1 > (readlnOrNull()?.toIntOrNull() ?: 0)) println("El primer número es mayor") else print("El segundo número es mayor")
}

fun ejercicio8() {
    // Ingresar 3 notas de un alumno, si el promedio es mayor o igual a siete mostrar un mensaje "Promocionado".
    val notas: MutableList<Int> = mutableListOf()
    for (x in 1..3){
        print("Introduce nota $x:")
        notas.add(readlnOrNull()?.toIntOrNull() ?: 0)
    }
    if (notas.isNotEmpty() && notas.average()>7){
        println("Promocionado")
    }
}

fun ejercicio9(){
    var condicion: Boolean = true
    while (condicion) {
        print("Ingresa un número entre 1 - 99 (inclusives): ")
        val numero: Int = (readlnOrNull()?.toIntOrNull() ?: 0).coerceIn(1, 99)
        when (numero) {
            in 1..9 -> println("Tiene 1 digito")
            in 10..99 -> println("Tiene 2 digitos")
        }
        print("¿Quieres seguir?")
        var respuesta : String = (readlnOrNull()?.trim() ?: "").lowercase()
        if (respuesta == "si") {
            condicion = true
        } else {
                condicion = false
            }
        }
    }

fun ejercicio10() {
    val numero: Int = readlnOrNull()?.toIntOrNull() ?: 0
    if (numero % 2 == 0) {
        val numero_cuadrado: Int = numero * numero
    } else {
        val numero_cubo: Int = numero * numero * numero
    }
}

fun ejercicio11() {
    val notas: MutableList<Int> = mutableListOf()
    for (x in 1..3) {
        print("Ingrese la nota $x: ")
        notas.add(readlnOrNull()?.toIntOrNull() ?: 0)
    }
    println("El promedio es: ${notas.average()}")
    if (notas.average() >= 7) {
        print("Promocionado")
    } else if (notas.average() < 4) {
        print("Reprobado")
    } else {
        print("Regular")
    }
}

fun ejercicio12() {
    println("¿Cuántas preguntas se te realizaron? ")
    val num_preguntas : Int = readlnOrNull()?.toIntOrNull() ?: 0
    println("¿Cuántas respondiste bien? ")
    val num_bien : Int = readlnOrNull()?.toIntOrNull() ?: 0
    val porcentaje : Float = (num_preguntas / num_bien).toFloat()
    when {
        porcentaje >= 0.90 -> print("Nivel Máximo")
        porcentaje in 0.75..0.89 -> print("Nivel Medio")
        porcentaje in 0.50..0.74 -> print("Nivel Regular")
        porcentaje < 50 -> print("Fuera de nivel")
    }
}

fun ejercicio13() {
    print("Día: ")
    var dia : Int = (readlnOrNull()?.toIntOrNull()?:1).coerceIn(1,31)
    print("Mes: ")
    var mes : Int = (readlnOrNull()?.toIntOrNull()?:1).coerceIn(1,12)
    print("Año: ")
    var año : Int = (readlnOrNull()?.toIntOrNull()?:1).coerceIn(1,2027)
    println("Día: $dia Mes: $mes Año: $año")
    if (mes in 1..3){
        println("Pertenece al primer trimestre del año.")
    }else{
        println("No pertenece al primer trimestre del año")
    }
}

// Estructuras de control (While)

fun ejercicio14() {
    print("Dime un valor positivo: ")
    var num: Int = (readlnOrNull()?.toIntOrNull()?:0).coerceAtLeast(1)
    var condicion: Boolean = true
    while (condicion == true){
        for (x in 1..num) {
            if (x < num){
                print("$x - ")
            }else{
                print("$x")
            }
        }
        condicion = false
    }
}

fun ejercicio15() {
    var lista: MutableList<Float> = mutableListOf()
    println("Dime 10 valores --> ")
    for (x in 1..10){
        print("Valor $x: ")
        var valor = readlnOrNull()?.toFloatOrNull()?: 0f
        lista.add(valor)
    }
    print("La suma es: ${lista.sum()} \n")
    print("El promedio es: ${lista.average()}")
}

fun triangulos() {
    val triangulo: MutableList<Float> = mutableListOf()
    var equilatero: Int = 0
    var isosceles: Int = 0
    var escaleno: Int = 0
    for (x in 1..3){
        print("Dime la longitud del lado $x: ")
        var lado = readlnOrNull()?.toFloatOrNull()?:0f
        triangulo.add(lado)
    }
    when {
        triangulo[0]==triangulo[1]&&triangulo[1]==triangulo[2] -> {
            println("Es un triangulo Equilatero")
            equilatero+= 1
        }
        triangulo[0]==triangulo[1]||triangulo[0]==triangulo[2] || triangulo[1]==triangulo[2] -> {
            println("Es un triangulo Isósceles")
            isosceles += 1
        }
        else -> {
            println("Es un triángulo escaleno")
            escaleno += 1
        }
    }
}


