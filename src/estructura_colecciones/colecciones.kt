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
            print("Introduce el sueldo ${it+1}: ")
            (readlnOrNull()?.toFloatOrNull()?:0f)
    }
    print(lista)
}

fun ejercicio6_colecciones(){
    // 6. Desarrollar un programa que permita ingresar una lista de N-elementos, ingresar los elementos por teclado.
    //a) Elaborar una función, donde inicialice cada posición de la lista y devuelva la posición de la suma de todos sus elementos

    print("Tamaño de la lista: ")
    val cantidad = readlnOrNull()?.toIntOrNull()?:1
    val lista = MutableList(cantidad){
        print("Elemento ${it+1} : ")
        (readlnOrNull()?.toFloatOrNull()?:0f)
    }
    print(lista.sum())
}

fun ejercicio7_colecciones(){
    // 7. Declare una lista inmutable llamada "listaDiasSemana", donde almacena los días de la semana en abreviatura
    //a) imprima la lista
    //b) imprima la posición del día "Martes" dentro de la lista
    //c) imprima el valor la primera posición de la lista
    //d) imprima el valor la última posición de la lista
    //e) devuelva el valor de la primera posición
    //f) devuelva el tamaño de la lista
    //g) devuelva la posición donde se encuentre el valor "Lun"
    //h) verificar si el valor "jue" esta dentro de la lista
    //i) declare una lista llamada listaFinde, donde sus valores sean "Vie", "Sab" y "Dom"
    //j) imprima la listaFinde
    //k) declare una "ListaCopia1" a partir de listaDiasSemana donde almacene solamente los valores que tengan mas de 4 letras
    //l) declare una "ListaCopia1" a partir de listaDiasSemana donde almacene solamente los valores que tengan o contenga la letra "M"
    //m) imprima las listas "ListaCopia1" y "listaCopia2"

    val lista_semana = listOf("Lunes","Martes","Mie","Jue","Vie","Sab","Dom")
    println(lista_semana)
    println(lista_semana.indexOf("Martes"))
    println(lista_semana.first())
    println(lista_semana.last())
    println(lista_semana.size)
    println(lista_semana.indexOf("L"))
    println(lista_semana.contains("J"))
    val lista_finde = listOf("Vie","Sab","Dom")
    println(lista_finde)
    val listaCopia1 = lista_semana.filter {it.length > 4}
    val listaCopia2 = lista_semana.filter { it.contains("M") }
    println(listaCopia1)
    println(listaCopia2)
}

fun ejercicio8_colecciones(){
    //8. Crear una lista mutable con las edades de varias personas. Las edades se introducen por teclado, y solicite cuanta edades va a introducir o almacenar.
    //a) Diga el promedio de edades
    //b) Cantidad de personas mayores de edad (18 años)
    //c) Ingrese una edad al principio y al final de la lista  e imprima la nueva lista
    //d) elimine la primera edad y la ultima de la lista  e imprima la nueva lista
    //e) elimine de la lista las edades igual a 16 e imprima la lista
    //f) elimine toda la lista e imprima
    print("Introduce la cantidad de datos: ")
    val cantidad = readlnOrNull()?.toIntOrNull()?:1
    val lista_mutable = MutableList(cantidad){
        print("Elemento ${it+1}: ")
        readlnOrNull()?.toIntOrNull()?:0
    }
    print("Promedio: ${lista_mutable.average()}")
    print("Cantidad de personas mayores de edad: ${lista_mutable.filter { it > 18 }.sum()}")
    lista_mutable.addFirst(50)
    lista_mutable.addLast(34)
    print(lista_mutable)
    lista_mutable.drop(0)
    lista_mutable.drop(-1)
    lista_mutable.dropWhile { it == 16 }

}

fun ejercicio9_colecciones(){
    //9.Crear una lista mutable de 10 elementos con valores aleatorios comprendidos entre 1 y 6.
    //a) Contar cuantos elementos tienen almacenado el valor 1.
    //b) Eliminar los elementos que almacenan un 6.
    val lista_mut = MutableList(10){
        (1..6).random()
    }
    println(lista_mut)

    println(lista_mut.filter { it == 1 }.sum())
    lista_mut.dropWhile { it == 6 }
    println(lista_mut)
}

fun ejercicio10_colecciones(){
    //10.Crear una lista mutable de 100 elementos enteros con valores aleatorios  comprendidos entre 0 y 20.contar
    //a) cuantos hay comprendidos entre 1 y 4, 5 y 8 y cuantos entre 10 y 13.
    //b) Imprimir si el valor 20 está presente en la lista
    //c) Solicite un numero por teclado e imprima la posición dentro de la lista en caso de existir
    val lista_mutable = MutableList(100){
        (0..20).random()
    }
    println("Hay ${lista_mutable.count { it in 1..4 }} entre 1 y 4")
    println("Hay ${lista_mutable.count { it in 5..8 }} entre 5 y 8")
    println("Hay ${lista_mutable.count { it in 10..13 }} entre 10 y 13")

    val estael20 = lista_mutable.any { it==20 }
    if (estael20){
        println("Contiene el 20")
    }else{
        println("No contiene el 20")
    }

    val numero = readlnOrNull()?.toIntOrNull()?:0
    print("Indice de $numero es: ${lista_mutable.indexOf(numero)}")
}

fun ejercicio12_colecciones(){
    //12. Crear un mapa que permita almacenar 5 artículos, utilizar como clave el nombre del productos y como valor el precio del mismo. Desarrollar además las funciones de:
    //a) Imprimir en forma completa el diccionario
    //b) Mostrar la cantidad de artículos con precio superior a 20.

    val mapa = mapOf(
        "Pan" to 1,
        "Coche" to 220,
        "Tren" to 45,
        "Tomate" to 13,
        "Car" to 1000
        )
}

    fun imprimir(mapa: Map<String, Int>) = mapa


    fun cantidadmayor20(mapa: Map<String, Int>) =
        mapa.count { it.value > 20 }


