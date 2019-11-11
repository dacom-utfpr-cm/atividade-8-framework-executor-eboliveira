// Autor: Eduardo Barbosa de Oliveira               Dia:11/11/2019

import java.util.concurrent.Callable
import java.util.concurrent.Executors

fun main(){
    val matrix = arrayListOf(arrayListOf(1, 2, 3), arrayListOf(4,5,6), arrayListOf(7,8,9))
    println(sumMatrix(matrix, 10))
}

fun sumMatrix(matrix: List<List<Int>>, nThreads: Int) :Int{
    val executor = Executors.newFixedThreadPool(nThreads)

    val runnables = arrayListOf<Callable<Int>>()

    for(line in matrix){
        runnables.add(SumLine(line))
    }

    val futures = executor.invokeAll(runnables)
    val responses = arrayListOf<Int>()
    for(future in futures){
        responses.add(future.get())
    }

    executor.shutdown()
    return responses.sum()
}