# Colecciones en Kotlin

Una **colección** es una estructura de datos que agrupa varios elementos en una sola variable. En Kotlin las colecciones se dividen en:

- **Inmutables (solo lectura):** permiten consultar y recorrer, pero no modificar el contenido (`List`, `Set`, `Map`).
- **Mutables:** permiten además añadir, eliminar y actualizar elementos (`MutableList`, `MutableSet`, `MutableMap`).

Tipos principales:

| Tipo | Mutable | Inmutable | Característica |
|------|---------|-----------|----------------|
| List | `MutableList` | `List` | Colección ordenada que admite duplicados |
| Set  | `MutableSet` | `Set` | Colección sin elementos duplicados |
| Map  | `MutableMap` | `Map` | Pares clave-valor, claves únicas |

---

## 1. Listas

Una **lista** es una colección **ordenada** de elementos que **admite duplicados**. Cada elemento tiene un índice (0, 1, 2, ...).

### 1.1 Lista inmutable (`List<T>`)

Se crea con `listOf()`. Es de solo lectura: no se puede añadir, eliminar ni modificar.

#### Ejemplo

```kotlin
val dias = listOf("Lun", "Mar", "Mie", "Jue", "Vie", "Sab", "Dom")

println(dias)                    // [Lun, Mar, Mie, Jue, Vie, Sab, Dom]
println(dias.size)               // 7
println(dias[0])                 // Lun
println(dias.first())            // Lun
println(dias.last())             // Dom
println(dias.indexOf("Mar"))     // 1
println(dias.contains("Jue"))    // true

val finde = dias.filter { it == "Sab" || it == "Dom" }
println(finde)                   // [Sab, Dom]
```

#### Métodos principales

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `size` | Número de elementos | `dias.size` |
| `[index]` / `get(index)` | Elemento en una posición | `dias[2]` |
| `first()` / `last()` | Primer / último elemento | `dias.first()` |
| `indexOf(x)` | Posición del valor, `-1` si no existe | `dias.indexOf("Mar")` |
| `contains(x)` / `x in lista` | ¿Contiene el valor? | `"Lun" in dias` |
| `isEmpty()` / `isNotEmpty()` | ¿Vacía / con elementos? | `dias.isNotEmpty()` |
| `count { ... }` | Cuántos cumplen la condición | `dias.count { it.length == 3 }` |
| `filter { ... }` | Nueva lista con los que cumplen | `dias.filter { it.startsWith("M") }` |
| `map { ... }` | Nueva lista transformando cada elemento | `dias.map { it.uppercase() }` |
| `sorted()` / `sortedDescending()` | Nueva lista ordenada | `dias.sorted()` |
| `reversed()` | Nueva lista en orden inverso | `dias.reversed()` |
| `forEach { ... }` | Recorre cada elemento | `dias.forEach { println(it) }` |
| `sum()` / `average()` | Suma / media (numéricas) | `nums.sum()` |
| `joinToString()` | Convierte a `String` | `dias.joinToString(", ")` |

### 1.2 Lista mutable (`MutableList<T>`)

Se crea con `mutableListOf()` o `MutableList(n) { ... }`. Además de todos los métodos de lectura, permite modificar su contenido.

#### Ejemplo

```kotlin
val edades = mutableListOf(20, 16, 30)

edades.add(25)            // [20, 16, 30, 25]
edades.add(0, 18)         // [18, 20, 16, 30, 25]
edades[1] = 21            // modifica el índice 1
edades.removeAt(0)        // elimina el primero
edades.remove(16)         // elimina la primera aparición del valor
edades.removeAll { it < 18 } // elimina por condición
edades.sort()             // ordena la propia lista
println(edades)
edades.clear()            // vacía la lista: []
```

#### Métodos principales de modificación

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `add(x)` | Añade al final | `lista.add(5)` |
| `add(i, x)` | Inserta en la posición `i` | `lista.add(0, 5)` |
| `addAll(otra)` | Añade todos los elementos de otra colección | `lista.addAll(listOf(1, 2))` |
| `remove(x)` | Elimina la primera aparición | `lista.remove(3)` |
| `removeAt(i)` | Elimina el índice `i` | `lista.removeAt(0)` |
| `removeAll { ... }` | Elimina los que cumplen la condición | `lista.removeAll { it < 0 }` |
| `set(i, x)` / `[i] = x` | Modifica el elemento en `i` | `lista[0] = 9` |
| `sort()` / `sortDescending()` | Ordena la lista en su lugar | `lista.sort()` |
| `reverse()` | Invierte la lista en su lugar | `lista.reverse()` |
| `clear()` | Elimina todos los elementos | `lista.clear()` |

---

## 2. Sets

Un **set** es una colección **sin elementos duplicados**. Se usa cuando interesa unicidad, no posiciones.

### 2.1 Set inmutable (`Set<T>`)

Se crea con `setOf()`. Los duplicados se descartan automáticamente.

#### Ejemplo

```kotlin
val numeros = setOf(1, 2, 3, 3, 4, 2)

println(numeros)              // [1, 2, 3, 4]
println(numeros.size)         // 4
println(3 in numeros)         // true
println(numeros.contains(5))  // false
println(numeros.first())      // 1

val pares = numeros.filter { it % 2 == 0 }
println(pares)                // [2, 4]
```

#### Métodos principales

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `size` | Número de elementos | `numeros.size` |
| `contains(x)` / `x in set` | ¿Contiene el valor? | `3 in numeros` |
| `isEmpty()` / `isNotEmpty()` | ¿Vacío / con elementos? | `numeros.isNotEmpty()` |
| `first()` / `last()` | Primer / último elemento | `numeros.first()` |
| `filter { ... }` | Nuevo set con los que cumplen | `numeros.filter { it > 2 }` |
| `map { ... }` | Transforma cada elemento | `numeros.map { it * 10 }` |
| `union(otro)` | Unión de dos sets | `a.union(b)` |
| `intersect(otro)` | Elementos comunes | `a.intersect(b)` |
| `subtract(otro)` | Elementos que no están en el otro | `a.subtract(b)` |

### 2.2 Set mutable (`MutableSet<T>`)

Se crea con `mutableSetOf()`. Permite añadir y eliminar manteniendo la unicidad.

#### Ejemplo

```kotlin
val etiquetas = mutableSetOf("kotlin", "java")

etiquetas.add("python")      // añade nuevo
etiquetas.add("kotlin")      // NO se añade: ya existe
etiquetas.remove("java")     // elimina el valor
println(etiquetas)           // [kotlin, python]
etiquetas.clear()            // []
```

#### Métodos principales de modificación

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `add(x)` | Añade si no existe | `set.add(5)` |
| `addAll(otra)` | Añade todos los que no existan | `set.addAll(listOf(1, 2))` |
| `remove(x)` | Elimina el valor | `set.remove(3)` |
| `removeAll { ... }` | Elimina por condición | `set.removeAll { it < 0 }` |
| `clear()` | Vacía el set | `set.clear()` |

---

## 3. Mapas

Un **mapa** (`Map`) almacena pares **clave-valor**. Las claves son únicas; cada clave apunta a un valor. Se accede por clave, no por índice.

### 3.1 Mapa inmutable (`Map<K, V>`)

Se crea con `mapOf()` usando `Pair(clave, valor)` o el operador `clave to valor`.

#### Ejemplo

```kotlin
val paises = mapOf(
    "españa" to 46_000_000,
    "argentina" to 40_000_000,
    "uruguay" to 3_400_000
)

println(paises)                      // {españa=46000000, argentina=40000000, uruguay=3400000}
println(paises["españa"])            // 46000000
println(paises["brasil"])            // null (clave no existe)
println(paises.size)                 // 3
println(paises.keys)                 // [españa, argentina, uruguay]
println(paises.values)               // [46000000, 40000000, 3400000]
println("españa" in paises)          // true
println(paises.values.sum())         // 89400000

paises.forEach { (clave, valor) ->
    println("$clave -> $valor")
}
```

#### Métodos principales

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `[clave]` / `get(clave)` | Valor asociado, `null` si no existe | `paises["españa"]` |
| `getValue(clave)` | Valor asociado, lanza excepción si no existe | `paises.getValue("españa")` |
| `getOrDefault(k, v)` | Valor o valor por defecto | `paises.getOrDefault("brasil", 0)` |
| `size` | Número de pares | `paises.size` |
| `keys` | Conjunto de claves | `paises.keys` |
| `values` | Colección de valores | `paises.values` |
| `entries` | Conjunto de pares clave-valor | `paises.entries` |
| `containsKey(k)` / `k in map` | ¿Existe la clave? | `"españa" in paises` |
| `containsValue(v)` | ¿Existe el valor? | `paises.containsValue(3400000)` |
| `filter { ... }` | Filtra pares por condición | `paises.filter { it.value > 10_000_000 }` |
| `filterKeys { ... }` | Filtra por clave | `paises.filterKeys { it.startsWith("a") }` |
| `filterValues { ... }` | Filtra por valor | `paises.filterValues { it > 0 }` |
| `map { ... }` / `mapValues { ... }` / `mapKeys { ... }` | Transforma pares, valores o claves | `paises.mapValues { it.value * 2 }` |
| `count { ... }` | Cuántos pares cumplen | `paises.count { it.value > 5_000_000 }` |
| `forEach { ... }` | Recorre cada par | `paises.forEach { (k, v) -> println("$k=$v") }` |

### 3.2 Mapa mutable (`MutableMap<K, V>`)

Se crea con `mutableMapOf()`. Permite añadir, actualizar y eliminar pares.

#### Ejemplo

```kotlin
val productos = mutableMapOf(
    "papas" to 12.5,
    "manzanas" to 26.0
)

productos["peras"] = 31.0       // añade nuevo par
productos["papas"] = 15.0       // actualiza el valor de la clave
productos.remove("manzanas")    // elimina el par por clave
println(productos)              // {papas=15.0, peras=31.0}
productos.clear()               // {}
```

#### Métodos principales de modificación

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `[k] = v` / `put(k, v)` | Añade o actualiza el par | `mapa["a"] = 1` |
| `putAll(otro)` | Añade/actualiza todos los pares de otro mapa | `mapa.putAll(otroMapa)` |
| `remove(k)` | Elimina el par por clave | `mapa.remove("a")` |
| `getOrPut(k) { ... }` | Devuelve el valor o lo crea si no existe | `mapa.getOrPut("a") { 0 }` |
| `clear()` | Elimina todos los pares | `mapa.clear()` |

---

## Resumen comparativo

| Característica | `List` | `Set` | `Map` |
|----------------|--------|-------|-------|
| Orden | Sí (por índice) | No garantizado | Por clave |
| Duplicados | Permitidos | No permitidos | Claves únicas |
| Acceso | Por índice `[i]` | Por valor (`in`) | Por clave `[k]` |
| Creación inmutable | `listOf()` | `setOf()` | `mapOf()` |
| Creación mutable | `mutableListOf()` | `mutableSetOf()` | `mutableMapOf()` |
