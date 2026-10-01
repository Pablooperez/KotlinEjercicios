package estructura_colecciones
/*
Pueden existir varias funciones main() en un mismo proyecto en Kotlin, pero con restricciones:

- En el mismo paquete: no puedes tener dos funciones con la misma firma (fun main() o fun main(args: Array<String>))
  porque genera un error de duplicado.
- En paquetes distintos: sí puedes tener varias main(), ya que pertenecen a clases JVM diferentes.
- Punto de entrada: al ejecutar el proyecto, debemos indicar cuál fun main() queremos usar.
  Si intentamos ejecutar sin especificar y hay varias, el IDE o compilador dará error por ambigüedad.

*/
/* ================================================================================
     List INMUTABLE
  ================================================================================

Una lista inmutable (List<T>) es de solo lectura:
 - se puede realizar consultas pero no modificarla ni cambiarla


Características
- No está permitido: añadir, eliminar ni modificar elementos.
- Está permitido: leer, recorrer, buscar, filtrar y crear nuevas listas a partir de ella.

Nota:
 una List<T> en Kotlin está tipada: todos sus elementos deben ser de tipo T (o un subtipo).
 sí podemos mezclar tipos distintos, si los tratamos como un supertipo común, normalmente Any o Any?.

FORMAS DE DECLARACIÓN DE UNA LIST INMUTABLE
--------------------------------------------
| Forma                          | Descripción                                      | Ejemplo                                  |
|--------------------------------|--------------------------------------------------|------------------------------------------|
| Vacía                          | Lista sin elementos                              | val v = emptyList<String>()              |
| Con valores iniciales          | Tamaño fijo dado por los elementos               | val n = listOf(1, 2, 3)                  |
| Tamaño fijo con generador      | Crea n elementos usando el índice                | val c = List(5) { it * it }              |
| Nulable                        | La referencia a la lista puede ser null          | val l: List<Int>? = null                 |
| Con elementos nulos            | Elementos del tipo pueden ser null               | val l: List<Int?> = listOf(1, null, 3)   |
| Vista de una lista mutable     | Referencia inmutable a una MutableList           | val v: List<Int> = mutableListOf(1, 2)   |
| Tipos mixtos (vía supertipo)   | Diferentes tipos tratados como Any/Any?          | val m: List<Any> = listOf(1, "hola")     |
 */

fun main() {
    /* ================================================================================
         Declaraciones :  List INMUTABLE
      ================================================================================ */

    // Distintas formas de declaración
    // 1. Lista vacía
    val listaVacia1 = emptyList<String>()
    val listaaVacia2 = listOf<String>()

    println("Lista vacía: $listaVacia1")
    println("Otra vacía: $listaaVacia2")

    // 2. Lista con valores iniciales (tamaño fijo)
    val numeros = listOf(1, 2, 3, 4, 5,6)
    val lenguajes = listOf("Rust", "Python", "Kotlin", "Ensamblador", "Java", "C++")

    println("Números: $numeros")
    println("lenguajes: $lenguajes")

    // 3. Lista con tamaño fijo y valor generado
    /*  - La función List(size) { ... } crea una lista inmutable de longitud size,
          llamando a la lambda una vez por cada posición para generar el valor.
        - it: es el nombre automático (iterador) del único parámetro de la lambda:
               el índice de la posición que se está creando. Va desde 0 hasta size - 1.
     */
    val listaDeCeros = List(6) { 0 } // cada elemento con valor 0
    val indices = List(6) { it }     // it vale 0, 1, 2, 3, 4 y 5 en cada llamada.
    val cuadrados = List(6) { it * it } // it toma el valor del indice o lo multiplica por el mismo valor

    println("Ceros: $listaDeCeros")  // [0, 0, 0, 0, 0, 0]
    println("Índices: $indices")     // [0, 1, 2, 3, 4]
    println("Cuadrados: $cuadrados") // [0, 1, 4, 9, 16]

    // 4. Lista nulable
    val listaNullable: List<Int>? = null
    println("Lista nulable: $listaNullable")

    // 5. Lista con elementos nulables
    val listaConNulos: List<Int?> = listOf(1, null, 3)
    println("Con nulos: $listaConNulos")

    // 6. Vista inmutable de una lista mutable
    val mutable = mutableListOf(1, 2, 3)
    val inmutable: List<Int> = mutable
    println("Vista inmutable: $inmutable")

    // 7. Lista mixta
    val mixta1: List<Any> = listOf(1, "hola", 3.14, true)
    val mixta2: List<Any?> = listOf(1, "hola", 3.14, true, null)

    /*
  ================================================================================
  PRINCIPALES MÉTODOS DE List INMUTABLE EN KOTLIN
  ================================================================================

  ACCESO A ELEMENTOS
  ------------------
  | Métodos                 | Descripción                              | Ejemplo                           |
  |------------------------|------------------------------------------|-----------------------------------|
  | size                   | Número de elementos                      | datos.size                        |
  | get(index) o [index]   | Elemento en una posición                 | datos[2]                          |
  | first()                | Primer elemento                          | datos.first()                     |
  | last()                 | Último elemento                          | datos.last()                      |
  | first { ... }          | Primer elemento que cumple una condición | datos.first { it > 3 }            |

  CONSULTAS
  ---------
  | Métodos        | Descripción                      | Ejemplo                           |
  |---------------|----------------------------------|-----------------------------------|
  | isEmpty()     | ¿La lista está vacía?            | lista.isEmpty()                   |
  | isNotEmpty()  | ¿La lista tiene elementos?       | lista.isNotEmpty()                |
  | contains(x)   | ¿Contiene el valor x?            | datos.contains(5)                 |
  | indexOf(x)    | Posición del valor x             | datos.indexOf(3)                  |
  | lastIndexOf(x)| Última posición del valor x      | datos.lastIndexOf(1)              |
  | count { ... } | Cuántos cumplen la condición     | datos.count { it > 2 }            |
  | any { ... }   | ¿Alguno cumple la condición?     | datos.any { it > 4 }              |
  | all { ... }   | ¿Todos cumplen la condición?     | datos.all { it > 0 }              |
  | none { ... }  | ¿Ninguno cumple la condición?    | datos.none { it < 0 }             |

  TRANSFORMACIONES (devuelven una nueva lista)
  --------------------------------------------
  | Métodos              | Descripción                             | Ejemplo                                    |
  |---------------------|-----------------------------------------|--------------------------------------------|
  | reversed()          | Invierte el orden                       | datos.reversed()                           |
  | sorted()            | Orden ascendente                        | datos.sorted()                             |
  | sortedBy { ... }    | Ordena por criterio                     | palabras.sortedBy { it.length }            |
  | sortedDescending()  | Orden descendente                       | datos.sortedDescending()                   |
  | filter { ... }      | Elementos que cumplen                   | datos.filter { it % 2 == 0 }               |
  | map { ... }         | Transforma cada elemento                | datos.map { it * it }                      |
  | take(n)             | Primeros n elementos                    | datos.take(3)                              |
  | drop(n)             | Ignora los primeros n                   | datos.drop(2)                              |
  | takeWhile { ... }   | Toma mientras se cumpla                 | datos.takeWhile { it < 5 }                 |
  | dropWhile { ... }   | Ignora mientras se cumpla               | datos.dropWhile { it < 5 }                 |
  | distinct()          | Elimina duplicados                      | datos.distinct()                           |
  | subList(a, b)       | Fragmento entre índices a (inclusive) y b (exclusivo) | datos.subList(1, 4)        |
  | zip(otra)           | Empareja dos listas                     | numeros.zip(letras)                        |
  | slice(indices)      | Elementos en posiciones indicadas       | datos.slice(listOf(0, 2, 4))               |

  AGREGACIÓN
  ----------
  | Métodos              | Descripción                             | Ejemplo                                    |
  |---------------------|-----------------------------------------|--------------------------------------------|
  | joinToString(...)   | Convierte a String                      | datos.joinToString(", ")                  |
  | sum()               | Suma (valores numéricos)                | datos.sum()                                |
  | average()           | Media aritmética                        | datos.average()                            |
  | maxOrNull()         | Máximo o null si está vacía             | datos.maxOrNull()                          |
  | minOrNull()         | Mínimo o null si está vacía             | datos.minOrNull()                          |
  | sumOf { ... }       | Suma transformada                       | datos.sumOf { it * 2 }                     |
  | reduce { ... }      | Acumula usando primer y siguiente       | datos.reduce { a, b -> a + b }             |
  | fold(inicial) { ...}| Acumula con valor inicial               | datos.fold(0) { a, b -> a + b }            |
  */




    // 8. Métodos principales de List inmutable
    val datos = listOf(3, 1, 4, 1, 5, 9)
    val palabras = listOf("Kotlin", "Java", "C++")

    println("Tamaño: ${datos.size}")
    println("Elemento en índice 2: ${datos[2]}")
    println("Primero mayor que 3: ${datos.first { it > 3 }}")
    println("Ordenada: ${datos.sorted()}")
    println("Reversa: ${datos.reversed()}")
    println("Pares: ${datos.filter { it % 2 == 0 }}")
    println("Dobles: ${datos.map { it * 2 }}")
    println("Sin duplicados: ${datos.distinct()}")
    println("Primeros 3: ${datos.take(3)}")
    println("Unidos: ${datos.joinToString("-")}")
    println("Contiene 5: ${datos.contains(5)}")
    println("Alguno mayor que 8: ${datos.any { it > 8 }}")
    println("Todos positivos: ${datos.all { it > 0 }}")
    println("Suma: ${datos.sum()}")
    println("Ordenar por longitud: ${palabras.sortedBy { it.length }}")
}

/*
================================================================================
PRINCIPALES MÉTODOS DE List INMUTABLE EN KOTLIN
================================================================================

ACCESO A ELEMENTOS
------------------
| Método                 | Descripción                              | Ejemplo                           |
|------------------------|------------------------------------------|-----------------------------------|
| size                   | Número de elementos                      | datos.size                        |
| get(index) o [index]   | Elemento en una posición                 | datos[2]                          |
| first()                | Primer elemento                          | datos.first()                     |
| last()                 | Último elemento                          | datos.last()                      |
| first { ... }          | Primer elemento que cumple una condición | datos.first { it > 3 }            |

CONSULTAS
---------
| Método        | Descripción                      | Ejemplo                           |
|---------------|----------------------------------|-----------------------------------|
| isEmpty()     | ¿La lista está vacía?            | lista.isEmpty()                   |
| isNotEmpty()  | ¿La lista tiene elementos?       | lista.isNotEmpty()                |
| contains(x)   | ¿Contiene el valor x?            | datos.contains(5)                 |
| indexOf(x)    | Posición del valor x             | datos.indexOf(3)                  |
| lastIndexOf(x)| Última posición del valor x      | datos.lastIndexOf(1)              |
| count { ... } | Cuántos cumplen la condición     | datos.count { it > 2 }            |
| any { ... }   | ¿Alguno cumple la condición?     | datos.any { it > 4 }              |
| all { ... }   | ¿Todos cumplen la condición?     | datos.all { it > 0 }              |
| none { ... }  | ¿Ninguno cumple la condición?    | datos.none { it < 0 }             |

TRANSFORMACIONES (devuelven una nueva lista)
--------------------------------------------
| Método              | Descripción                             | Ejemplo                                    |
|---------------------|-----------------------------------------|--------------------------------------------|
| reversed()          | Invierte el orden                       | datos.reversed()                           |
| sorted()            | Orden ascendente                        | datos.sorted()                             |
| sortedBy { ... }    | Ordena por criterio                     | palabras.sortedBy { it.length }            |
| sortedDescending()  | Orden descendente                       | datos.sortedDescending()                   |
| filter { ... }      | Elementos que cumplen                   | datos.filter { it % 2 == 0 }               |
| map { ... }         | Transforma cada elemento                | datos.map { it * it }                      |
| take(n)             | Primeros n elementos                    | datos.take(3)                              |
| drop(n)             | Ignora los primeros n                   | datos.drop(2)                              |
| takeWhile { ... }   | Toma mientras se cumpla                 | datos.takeWhile { it < 5 }                 |
| dropWhile { ... }   | Ignora mientras se cumpla               | datos.dropWhile { it < 5 }                 |
| distinct()          | Elimina duplicados                      | datos.distinct()                           |
| subList(a, b)       | Fragmento entre índices a (inclusive) y b (exclusivo) | datos.subList(1, 4)        |
| zip(otra)           | Empareja dos listas                     | numeros.zip(letras)                        |
| slice(indices)      | Elementos en posiciones indicadas       | datos.slice(listOf(0, 2, 4))               |

AGREGACIÓN
----------
| Método              | Descripción                             | Ejemplo                                    |
|---------------------|-----------------------------------------|--------------------------------------------|
| joinToString(...)   | Convierte a String                      | datos.joinToString(", ")                  |
| sum()               | Suma (valores numéricos)                | datos.sum()                                |
| average()           | Media aritmética                        | datos.average()                            |
| maxOrNull()         | Máximo o null si está vacía             | datos.maxOrNull()                          |
| minOrNull()         | Mínimo o null si está vacía             | datos.minOrNull()                          |
| sumOf { ... }       | Suma transformada                       | datos.sumOf { it * 2 }                     |
| reduce { ... }      | Acumula usando primer y siguiente       | datos.reduce { a, b -> a + b }             |
| fold(inicial) { ...}| Acumula con valor inicial               | datos.fold(0) { a, b -> a + b }            |
*/

