# Listas inmutables en Kotlin

Una lista inmutable (`List<T>`) es de solo lectura: se puede consultar, recorrer, buscar y filtrar, pero **no** añadir, eliminar ni modificar elementos.

## Características

- **No está permitido:** añadir, eliminar ni modificar elementos.
- **Sí está permitido:** leer, recorrer, buscar, filtrar y crear nuevas listas a partir de ella.

> **Nota:** `List<T>` en Kotlin está tipada: todos sus elementos deben ser de tipo `T` (o un subtipo).  
> Se pueden mezclar tipos distintos si se tratan como un supertipo común, normalmente `Any` o `Any?`.

## Formas de declaración de una `List` inmutable

| Forma | Descripción | Ejemplo |
|-------|-------------|---------|
| Vacía | Lista sin elementos | `val v = emptyList<String>()` |
| Con valores iniciales | Tamaño fijo dado por los elementos | `val n = listOf(1, 2, 3)` |
| Tamaño fijo con generador | Crea `n` elementos usando el índice | `val c = List(5) { it * it }` |
| Nulable | La referencia a la lista puede ser `null` | `val l: List<Int>? = null` |
| Con elementos nulos | Los elementos del tipo pueden ser `null` | `val l: List<Int?> = listOf(1, null, 3)` |
| Vista de una lista mutable | Referencia inmutable a una `MutableList` | `val v: List<Int> = mutableListOf(1, 2)` |
| Tipos mixtos (vía supertipo) | Diferentes tipos tratados como `Any`/`Any?` | `val m: List<Any> = listOf(1, "hola")` |

## Métodos principales

### Acceso a elementos

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `size` | Número de elementos | `datos.size` |
| `get(index)` / `[index]` | Elemento en una posición | `datos[2]` |
| `first()` | Primer elemento | `datos.first()` |
| `last()` | Último elemento | `datos.last()` |
| `first { ... }` | Primer elemento que cumple la condición | `datos.first { it > 3 }` |

### Consultas

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `isEmpty()` | ¿La lista está vacía? | `lista.isEmpty()` |
| `isNotEmpty()` | ¿La lista tiene elementos? | `lista.isNotEmpty()` |
| `contains(x)` | ¿Contiene el valor `x`? | `datos.contains(5)` |
| `indexOf(x)` | Posición del valor `x` | `datos.indexOf(3)` |
| `lastIndexOf(x)` | Última posición del valor `x` | `datos.lastIndexOf(1)` |
| `count { ... }` | Cuántos cumplen la condición | `datos.count { it > 2 }` |
| `any { ... }` | ¿Alguno cumple la condición? | `datos.any { it > 4 }` |
| `all { ... }` | ¿Todos cumplen la condición? | `datos.all { it > 0 }` |
| `none { ... }` | ¿Ninguno cumple la condición? | `datos.none { it < 0 }` |

### Transformaciones (devuelven una nueva lista)

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `reversed()` | Invierte el orden | `datos.reversed()` |
| `sorted()` | Orden ascendente | `datos.sorted()` |
| `sortedBy { ... }` | Ordena por criterio | `palabras.sortedBy { it.length }` |
| `sortedDescending()` | Orden descendente | `datos.sortedDescending()` |
| `filter { ... }` | Elementos que cumplen | `datos.filter { it % 2 == 0 }` |
| `map { ... }` | Transforma cada elemento | `datos.map { it * it }` |
| `take(n)` | Primeros `n` elementos | `datos.take(3)` |
| `drop(n)` | Ignora los primeros `n` | `datos.drop(2)` |
| `takeWhile { ... }` | Toma mientras se cumpla | `datos.takeWhile { it < 5 }` |
| `dropWhile { ... }` | Ignora mientras se cumpla | `datos.dropWhile { it < 5 }` |
| `distinct()` | Elimina duplicados | `datos.distinct()` |
| `subList(a, b)` | Fragmento entre índices `a` (inclusive) y `b` (exclusivo) | `datos.subList(1, 4)` |
| `zip(otra)` | Empareja dos listas | `numeros.zip(letras)` |
| `slice(indices)` | Elementos en posiciones indicadas | `datos.slice(listOf(0, 2, 4))` |

### Agregación

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `joinToString(...)` | Convierte a `String` | `datos.joinToString(", ")` |
| `sum()` | Suma de valores numéricos | `datos.sum()` |
| `average()` | Media aritmética | `datos.average()` |
| `maxOrNull()` | Máximo o `null` si está vacía | `datos.maxOrNull()` |
| `minOrNull()` | Mínimo o `null` si está vacía | `datos.minOrNull()` |
| `sumOf { ... }` | Suma transformada | `datos.sumOf { it * 2 }` |
| `reduce { ... }` | Acumula usando el primero y el siguiente | `datos.reduce { a, b -> a + b }` |
| `fold(inicial) { ... }` | Acumula con valor inicial | `datos.fold(0) { a, b -> a + b }` |
