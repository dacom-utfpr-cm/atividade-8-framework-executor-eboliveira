// Autor: Eduardo Barbosa de Oliveira               Dia:11/11/2019

import java.util.concurrent.Callable
import java.util.concurrent.Executors

fun main(){
    val matrix = arrayListOf(arrayListOf(1, 2, 3), arrayListOf(4,5,6), arrayListOf(7,8,9))
    val matrix2 = arrayListOf(arrayListOf(1, 2, 3), arrayListOf(4,5,6), arrayListOf(7,8,9))
    println(matrixMultiplication(matrix, matrix2, 10))
}

fun matrixMultiplication(matrix: List<List<Int>>, matrix2: List<List<Int>>, nThreads: Int) :List<List<Int>>{
    val executor = Executors.newFixedThreadPool(nThreads)

    val runnables = arrayListOf<Callable<List<Int>>>()

    for(line in matrix){
        runnables.add(MultiplyArrays(line, matrix2))
    }

    val resultantMatrix = arrayListOf<List<Int>>()
    val futures = executor.invokeAll(runnables)
    for(future in futures){
        resultantMatrix.add(future.get())
    }

    executor.shutdown()
    return resultantMatrix
}