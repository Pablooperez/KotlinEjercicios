package poo
// -----------------------------------------------------------------------------------------------------------------
// TEMA 1.1 : DECLARACIÓN DE CLASES Y CONSTRUCTORES

class CuentaBancaria1(var titular : String, var saldoInicial : Double = 0.0) {

    var numeroCuenta : String = ""

    init {
        require(saldoInicial >= 0) {"El saldo inicial no puede ser negativo"}
    }

    constructor(titular : String, numeroCuenta : String) : this(titular, 50.0){
        this.numeroCuenta = numeroCuenta
    }
}

class Vehiculo (val marca : String, val puertas : Int){

    constructor(marca : String) : this(marca, 5)

}

// -----------------------------------------------------------------------------------------------------------------

// -----------------------------------------------------------------------------------------------------------------
// TEMA 1.2 : PROPIEDADES, CAMPOS DE RESPALDO (BACKING FIELDS) Y MÉTODOS DE ACCESO

//GET

class Usuario1 {
    var nombre: String = ""
        get() {
            // Se ejecuta cada vez que alguien LEE la propiedad
            return field.capitalize() // Por ejemplo, aseguramos que la primera letra sea mayúscula
        }
        set(value) {
            // Se ejecuta cada vez que alguien ESCRIBE o MODIFICA la propiedad
            if (value.isNotBlank()) {
                field = value.trim() // Limpiamos espacios en blanco antes de guardarlo
            }
        }
}

//SET

class Empleado1 {
    var sueldo :  Double = 0.0

        set(value) {
            if  (value < 0){
                println("El sueldo no puede ser negativo")
            } else {
                field = value
            }
        }
}

// GET PERSONALIZADO Y SET POR DEFECTO

class Empleado2 {
    var sueldo :  Double = 0.0
        get(){
            println("Se ha consultado el sueldo")
            return field
        }
        set(value) {
            if (value < 0){
                println("El saldo no puede ser negativo")
            }else{
                field = value
            }
        }
}

// -----------------------------------------------------------------------------------------------------------------

// -----------------------------------------------------------------------------------------------------------------
// TEMA 1.3 : MODIFICADORES DE VISIBILIDAD (PUBLIC, PRIVATE, PROTECTED, INTERNAL)

class CajaFuerte {
    private val pinSecreto : Int = 1234

    var estaAbierta : Boolean = false
        private set

    fun intentarAbrir(pin: Int): Boolean {
        if (pin == pinSecreto){
            estaAbierta = true
            return true
        }
        return estaAbierta
    }
}

class PuertaSeguridad  {
    private var intentosFallidos : Int = 0

    var bloqueada : Boolean = false
        private set

    fun comprobarLlave(llave : String) {
        if (llave != "1234"){
            intentosFallidos +=1
            if (intentosFallidos == 3){
                bloqueada = true
            }
        }
    }
}

// -----------------------------------------------------------------------------------------------------------------

// -----------------------------------------------------------------------------------------------------------------
// EJERCICIOS REPASO TEMA 1: - CONSTRUCTORES - PROPIEDADES CON CAMPOS DE RESPALDO (FIELD), GETTERS Y SETTERS - MODIFICADORES DE VISIBILIDAD

class Powerbank (var capacidadMaxima : Int, var nivelCargaActual : Int = 0) {

    init {
        require(capacidadMaxima > 0) {"La capacidad máxima no puede ser 0"}
        this.nivelCargaActual = nivelCargaActual.coerceIn(0, capacidadMaxima)
    }

    constructor(capacidadMaxima: Int) : this(capacidadMaxima,capacidadMaxima)

    fun usarDispositivo( energiaConsumida : Int){
        nivelCargaActual -= energiaConsumida
        println("Energia consumida. Nivel de carga actual: $nivelCargaActual mAh")
    }

}

class Termostato (val modelo :  String, temperaturaInicial : Double = 21.0) {
    var temperaturaDeseada : Double = temperaturaInicial
        private set(value){
            field = value.coerceIn(10.0, 30.0)
        }
    init {
        require(temperaturaDeseada in (10.0..30.0)) {"Temperatura anómala"}
        this.temperaturaDeseada=temperaturaInicial
    }

    constructor(modelo : String) : this(modelo,20.0)

    fun ajustarTemperatura(nuevaTemperatura: Double){
        this.temperaturaDeseada = nuevaTemperatura
        println("Temperatura ajustada a: $temperaturaDeseada")
    }

}





