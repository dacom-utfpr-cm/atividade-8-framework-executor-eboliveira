import java.util.concurrent.Callable
import java.util.concurrent.Executors

class SortWithBest{
    companion object {
        fun sort(array: IntArray): IntArray{
            val executorService = Executors.newFixedThreadPool(3)
            val callables = arrayListOf<Callable<IntArray>>()
            callables.add(Callable { Sort.bubble(array) })
            callables.add(Callable { Sort.insertion(array) })
            callables.add(Callable { Sort.selection(array) })
            val result = executorService.invokeAny(callables)
            executorService.shutdown()
            return result
        }
    }
}