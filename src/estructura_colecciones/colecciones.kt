package estructura_colecciones

import kotlin.math.round


fun ejercicio1_colecciones(){
    // 1. Se desea guardar los sueldos de 5 operarios.
    //a) Imprimir el primer valor
    //b) Imprimir el listado de los salarios
    val sueldos: MutableList<Float> = mutableListOf()
    for (i in 1..5){
        print("Introduce el sueldo del operario $i:  ")
        val sueldo = (readlnOrNull()?.toFloatOrNull()?:0f).coerceAtLeast(0f)
        sueldos.add(sueldo)
    }
    print("Sueldo operario 1: ${sueldos.first()} \n")
    print("Sueldos: ")

    sueldos.forEach { print("$it," ) }
}

fun ejercicio1_1_colecciones(){
    val sueldos = mutableListOf<Float>()
    (1..5).forEach {
        print("Ingrese el salario $it: ")
        sueldos.add((readlnOrNull()?.toFloatOrNull()?:0f).coerceIn(0f,Float.MAX_VALUE))
    }
    /* otra forma */
    val salarios = MutableList(size = 5){
        println("Ingrese el salario ${it+1}: ")
        (readlnOrNull()?.toFloatOrNull()?:0f).coerceIn(0f,Float.MAX_VALUE)
    }
}

fun ejercicio2_colecciones() {
    // 2. Definir una lista  de 5 componentes de tipo Float que representen las alturas de 5 personas.
    //a) Obtener la altura media
    //b) Contar cuántas personas son más altas que el promedio y cuántas más bajas.
    val alturas: MutableList<Float> = mutableListOf()
    for (i in 1..5) {
        print("Introduce la altura de la persona $i: ")
        alturas.add((readlnOrNull()?.toFloatOrNull() ?: 0f).coerceIn(0f, 2.50f))
    }
    print("La altura media es: ${"%.2f".format(alturas.average())} \n")
    println("Hay ${alturas.filter { it > alturas.average() }.size} personas mas altas que el promedio")
    println("Hay ${alturas.filter { it < alturas.average() }.size} personas mas bajas que el promedio")
}

fun ejercicio3_colecciones(){
    // 3. Hacer una lista de 10 elementos de tipo entero y verificar si esta ordenado de menor a mayor
    //a) Si no esta ordenado, preguntar al usuario si desea ordenar e imprima el arreglo ordenado
    val lista = mutableListOf<Int>()
    (1..10).forEach {
        print("Ingresa el elemento $it: ")
        lista.add(readlnOrNull()?.toIntOrNull()?:0)
    }
    if (lista.isSorted()==false) {
        print("No está ordenada. $lista ¿Quieres ordenarla? S/N: ")
        val respuesta = ((readlnOrNull()?: "S")).uppercase()
        if (respuesta.equals("S")) {
            lista.sort()
            print(lista)
        }else{
            print(lista)
        }
    }else{
        print("La lista estaba ordenada: $lista")
    }
}

fun ejercicio4_colecciones(){
    // 4. Leer una lista de 5 elementos de tipo entero. Imprimir luego el primer y último elemento.
    val lista = MutableList(5){
        print("Ingrese el elemento ${it+1}: ")
        ((readlnOrNull()?.toIntOrNull()?:0))
    }
    print("Primer elemento: ${lista.first()} \n")
    print("Último elemento: ${lista.last()}")
}

fun ejercicio5_colecciones(){
    // 5. Se desea almacenar los sueldos de operarios. Solicite la cantidad de sueldos a ingresar.
    // a) Luego crear una lista con dicho tamaño y definir una función de carga (leer datos) y otra de impresión.
    print("Introduce la cantidad de sueldos a ingresar: ")
    val cantidad = (readlnOrNull()?.toIntOrNull()?:1).coerceAtLeast(1)
    val lista = MutableList(cantidad){
            print("Introduce el sueldo $it: ")
            (readlnOrNull()?.toFloatOrNull()?:0f)
    }
    print(lista)

}
