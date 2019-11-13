//Autor: Eduardo Barbosa de Oliveira        Data: 12/11/2019
import java.util.*

fun main(){
    val array = IntArray(50000)
    for(i in 0 until 50000){
        array[i] = Random().nextInt(300000)
    }
    print("Array: ")
    println(array.toList())
    print("Sorted array: ")
    println(SortWithBest.sort(array).toList())
}