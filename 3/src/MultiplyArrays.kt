import java.util.concurrent.Callable

class MultiplyArrays(val array: List<Int>, val matrix: List<List<Int>>) : Callable<List<Int>> {
    override fun call(): List<Int> {
        val results = arrayListOf<Int>()
        var j = 0
        for (i in 0 until array.size) {
            val resultsLine = arrayListOf<Int>()
            for (line in matrix) {
                resultsLine.add(array[j] * line[i])
                j += 1
            }
            j = 0
            results.add(resultsLine.sum())
        }
        return results
    }
}