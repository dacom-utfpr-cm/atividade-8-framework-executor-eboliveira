//Autor: Eduardo Barbosa de Oliveira        Data: 12/11/2019
import java.util.*

fun main(){
    val millis = Calendar.getInstance().timeInMillis + 10_000 // tempo de agora + 10 segundos
    val date = Calendar.getInstance()
    date.timeInMillis = millis
    ScheduledTask(date, Runnable {
        println("Executei")
    }).run()
}