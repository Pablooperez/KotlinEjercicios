package poo

class Persona(nombre_entrada : String, val edad : Int){

    //1. Crear una clase Persona donde sus atributos son (Nombre y edad)"),
    //crear el método imprimir, donde se muestre la
    //clasificación de la persona según su edad. menor (<18años),joven (18
    //a 29 ), adulto en cualquier otro rango

    val nombre : String = nombre_entrada.replace(" ","").uppercase()

    init {
        require(edad>=0) {"La edad no puede ser negativa"}
        require(nombre.length>3&&nombre.isNotEmpty()){"Nombre Inváido"}
    }
    fun imprimir() = when(edad){
        in (0..18) -> "$nombre es Menor"
        in (19..29) -> "$nombre es Joven"
        else -> {"$nombre es Adulto"}
    }
}

class lados( lado1_entrada : Float? = null,  lado2_entrada : Float? = null, lado3_entrada : Float? = null){

    ///2. Crear un programa que se solicite los 3 lados de un triángulo y
    //tenga los métodos: ladoMayor y esEquilatero.
    //Realice tres constructores para esta clase. Indique siempre que
    //constructor se está ejecutando:
    //1 constructor principal se le pasa los valores de cada lado (lado1,
    //lado y lado3)
    //2 constructor no se le pasa ningún valor y solicita el valor de
    //(lado1 y lado2=, lado 3 es el valor de lado1
    //3 constructor se le pase el valor de un solo lado (lado1) e iguale
    //los restantes

    val lado1 : Float = 0f
    val lado2 : Float = 0f
    val lado3 : Float = 0f
    var lista : MutableList<Float> = mutableListOf()
    init {
        when {
            lado1_entrada != null && lado2_entrada != null && lado3_entrada != null -> {
                val lado1 : Float = lado1_entrada.coerceAtLeast(0.01f)
                val lado2 : Float = lado2_entrada.coerceAtLeast(0.01f)
                val lado3 : Float = lado3_entrada.coerceAtLeast(0.01f)
                lista.add(lado1)
                lista.add(lado2)
                lista.add(lado3)
            }

            lado1_entrada == null && lado2_entrada == null && lado3_entrada == null -> {
                for (i in 1..2){
                    print("Dime el valor del lado $i: ")
                    lista.add( (readln().toFloatOrNull() ?: 0f).coerceAtLeast(0.1f))
                }
                lista.add(lista[2])

            }

            lado1_entrada != null && lado2_entrada == null && lado3_entrada == null -> {
                val lado1 : Float = lado1_entrada.coerceAtLeast(0.01f)
                val lado2 : Float = lado1
                val lado3 : Float = lado1
                lista.add(lado1)
                lista.add(lado2)
                lista.add(lado3)

            }

        }

    }

    fun ladoMayor() = print("El lado mayor es lado {${lista.indexOf(lista.max())}} : {${lista.max()}}")

    fun esEquilatero() = when {
        lado1 == lado2 && lado3 == lado1 -> "Son equilateros"
        else -> {"No son equilateros"}
    }

}

class Notas(nombre : String, ){

    ///3. Crear un programa donde se le pase el nombre de un alumno y un
    //listado de sus 5 notas y tiene como métodos:
    //notaPromedio: Calcular el promedio de sus notas
    //detalleNotas: imprima la cantidad de asignatura por rango de nota.
    //Si la nota es >=7 mostrar "Promocionado" y la cantidad".
    //Si el promedio es >=5 y <7 mostrar "Regular" y la cantidad.
    //Si el promedio es <5 mostrar "Reprobado" y la cantidad.





}

class Ejercicio4(){

    ///4. Dato un punto (X,Y) decir la ubicación en el cuadrante al que
    //pertenece, llamando al método imprimir
    //1 constructor principal se le pasa los valores del punto(X,Y)
    //2 constructor secundario no se le pasa ningún valor y solicita el
    //valor X y Y
    //3 constructor tercero se le pase el valor X ( el punto siempre debe
    //estar sobre el eje Y)


}

class Ejercicio5(){

    ///5. Dado los datos de un empleado: nombre, apellidos, edad ,teléfono
    //,email y salario realice:
    //Tiene los siguientes métodos:
    //- método: imprimirEmpleado:
    //La información debe imprimirse con las siguientes características
    //* el nombre y apellidos siempre mayúsculas
    //* el salario con el formato " Salario: valor_salario € "
    //* el teléfono con el formato: (+34)xxx-xxx-xxx
    //* el email con el prefijo Gmail(para cuentas de gmail), Hotmail (para
    //cuentas de hotmail) Yahoo(para cuentas de yahoo)
    // y Otros (para cualquier otra cuenta)
    //ej.
    //Gmail: cuanta@gmail.com
    //Yahoo: cuanta@yahoo.com
    //Hotamil: cuenta@hotmail.com
    //Otro: cuenta@tame.com
    // Debe mostrarse la siguiente plantilla cuando se imprima los datos
    //de un empleado:
    // Datos del Empleado.
    // Nombre y Apellidos:
    // Edad:
    // Teléfono:
    // Email:
    // Salario:
    // Declara Impuesto:
    //- método: pagarImpuesto
    // * Si el salario es menor de 1500 "No Paga Impuesto"
    // * en el rango (1501 hasta 2000) paga el 16% del salario
    // * en el rango superior a 2001 pagara el 35% del salario



}