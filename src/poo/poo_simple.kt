package poo

class CuentaBancaria(
    var titular: String,
    val saldoInicial: Float = 0f
){
    var saldo = saldoInicial
    val esPositivo: Boolean = if (saldo > 0f) true else false

    fun ingresar(cantidad:Float){
        if (cantidad>0f){
            saldo += cantidad
            print("Has ingresado $cantidad €")
        }else{
            print("Error")
        }

    }
    fun retirar(cantidad: Float){
        if (saldo>=cantidad && cantidad>0){
            saldo -= cantidad
            print("Has retirado $cantidad €")
        }else{
            print("Saldo insuficiente")
        }
    }
    fun resumen(){
        print("RESUMEN\n" +
                "- Titular: $titular\n" +
                "- Saldo: $saldo\n" +
                "- Positivo: $esPositivo")
    }
}
fun crear_cuenta(nombre:String,saldo:Float){
    val cuentaPablo = CuentaBancaria(nombre,saldo)
    cuentaPablo.ingresar(100f)
    cuentaPablo.resumen()
    cuentaPablo.retirar(1000000f)
    cuentaPablo.retirar(10f)
    cuentaPablo.resumen()
}

enum class Departamento{
    VENTAS,
    DESARROLLO,
    RRHH,
    MARKETING
}

data class Nomina(
    val fecha_Inicio : String,
    val fecha_Fin : String,
    val horas : Float,
    val sueldo : Float
)

data class Empleado (
        val nombre: String,
        val edad: Int,
        val departamento: Departamento,
        val sueldo :  Float,
        val nomina : List<Nomina> = mutableListOf()
)

enum class NivelAcceso{
    INVITADO,
    REGISTRADO,
    ADMIN
}

data class Usuario(
    val login : String,
    val nombre : String,
    val nivel : String
)

fun crear_empleado(nombre:String,edad: Int,departamento: Departamento,nomina: List<Nomina>,sueldo: Float = 1280f) =
     Empleado("Pablo",26, Departamento.RRHH,1000f,mutableListOf())

val empl_1 = Empleado("Pablo",26, Departamento.RRHH,1000f,mutableListOf())



fun asignar_nomina(empleado: Empleado,nomina: Nomina){

}


