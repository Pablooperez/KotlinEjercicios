package funciones

fun ejercicio1_funciones(){
    //1. Realice un programa cuya función principal solicite el nombre al usuario y si
    //es válida la entrada de datos
    //a) llame a una función "muestraMiNombre" que muestre su nombre
    //b) llame a una función saludaKotlin que muestre el mensaje "Kotlin te da la bienvenida <el nombre del usuario>
    print("Dime tu nombre: ")
    val nombre = readlnOrNull().toString()
    muestraMiNombre(nombre)
    saludaKotlin(nombre)
}

fun muestraMiNombre(nombre: String) = println(nombre)
fun saludaKotlin(nombre: String) = println("Kotlin te da la bienvenida $nombre")

fun ejercicio2_funciones(){
    //2.Desarrollar un programa que permita ingresar el lado de un cuadrado. Luego
    //preguntar si quiere calcular y mostrar su perímetro o su superficie.
    print("Longitud del lado: ")
    val lado = readlnOrNull()?.toFloatOrNull()?:0.0f
    print("Que quieres calcular? (Perimetro/Superficie) :")
    val respuesta = readlnOrNull().toString().uppercase()
    if (respuesta=="PERIMETRO"){
        calcularperimetro(lado)
    }else{
        calcularsuperficie(lado)
    }
}

fun calcularperimetro(lado: Float) = println("El perímetro es: ${lado*4}")
fun calcularsuperficie(lado: Float) = println("La superficie es ${lado*lado}")

fun ejercicio3_funciones(){
    //3. Usemos rangos de números enteros para jugar el juego Fizz-Buzz.
    //Los jugadores se turnan para contar incrementalmente, reemplazando cualquier
    //número divisible por tres con la palabra Fizz y cualquier
    //número divisible por cinco con la palabra Buzz. Si un número es múltiplo de
    //ambos tres y cinco, dices "FizzBuzz".
    //Imprime las respuestas correctas para los números del 1 al 100.
    //Nota: cómo verifica las posibles condiciones con una expresión when sin un
    //argumento.

    for (i in 1..100){
        val respuesta = when{
            i % 3 == 0 && i % 5 == 0 -> "FizzBuzz "
            i % 3 == 0 -> "Fizz "
            i % 5 == 0 -> "Buzz "
            else -> "$i "
        }
        print(respuesta)
    }
}

fun ejercicio4_funciones(){
    //4. Calcule el factorial de un numero introducido por teclado
    print("Introduce un número: ")
    val numero = readlnOrNull()?.toIntOrNull()?:0
    var resultado = 1
    for (i in 1..numero) {
        resultado *= i
    }
    print(resultado)
}

fun ejercicio5_funciones(){
    //5. Dado un numero introducido por teclado, verifique si es un numero Perfecto
    //(La suma de todos sus divisores en el numero)
    print("Introduce un número: ")
    val numero = readlnOrNull()?.toIntOrNull()?:0
    var suma_divisores = 0
    for (i in 1..numero-1){
        if (numero % i == 0){
            suma_divisores += i
        }
    }
    if (numero == suma_divisores){
        print("Es un número perfecto")
    }else{
        print("No es un número perfecto")
    }
}

fun ejercicio6_funciones(){
    //6.Confeccionar una función que le enviemos como parámetro un String y nos
    //retorne la cantidad de caracteres que tiene.
    //En la función principal solicitar dos nombres por teclado e imprimir cual de las
    //dos palabras tiene más caracteres.
    fun contar_caracteres(palabra:String): Int{
        return palabra.count()
    }
    fun comparar(){
        print("Dime la palabra 1 : ")
        val palabra1 = readlnOrNull()?.toString()?:""
        val num_palabra1 = contar_caracteres(palabra1)
        print("Dime la palabra 2 : ")
        val palabra2 = readlnOrNull()?.toString()?:""
        val num_palabra2 = contar_caracteres(palabra2)
        print(when{
            num_palabra1==num_palabra2 -> "Tienen los mismos caracteres"
            num_palabra1>num_palabra2 -> "la palabra $palabra1 tiene más caracteres"
            else -> "La palabra $palabra2 tiene más caracteres"
        })
    }
    comparar()
    println("\n")
    val resultado = contar_caracteres("coche")
    print("La palabra 'coche' tiene $resultado caracteres")
}

fun ejercicio7_funciones(){
    //7. Elaborar un programa, cuya función principal solicite 2 números A y B por
    //teclado. Realice una función para cada una de estas operaciones:
    //a) sumar ambos números
    //b) Saber que numero es mayor
    //c) saber si el numero A esta en el rango de 0 al numero B

    val lista = MutableList(2){
        print("Número ${it+1}: ")
        readlnOrNull()?.toIntOrNull()?:0
    }

    fun sumar() = print(lista.sum())
    fun mayor() = print(lista.max())
    fun rango() {
        if (lista[0] in 0..lista[1])
            print("${lista[0]} Si que está en el rango")
    }
    sumar()
    print("\n")
    mayor()
    print("\n")
    rango()
}