// Autor: Eduardo Barbosa de Oliveira               Dia:11/11/2019

import java.util.concurrent.Callable
import java.util.concurrent.Executors

fun main(){
    val array = arrayListOf<Int>(20, 10, 30, 40, 80, 1, 2, 4, 70, 79)
    println(findMaxVector(array, 10))
}

fun findMaxVector(array: List<Int>, nThreads: Int) :Int{
    val executor = Executors.newFixedThreadPool(nThreads)
    val chunks = array.chunked(3)

    val runnables = arrayListOf<Callable<Int>>()

    for(chunk in chunks){
        runnables.add(FindMaxVector(chunk))
    }

    val futures = executor.invokeAll(runnables)
    val responses = arrayListOf<Int>()
    for(future in futures){
        responses.add(future.get())
    }

    executor.shutdown()
    return responses.max()!!
}