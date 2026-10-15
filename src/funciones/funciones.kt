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
}