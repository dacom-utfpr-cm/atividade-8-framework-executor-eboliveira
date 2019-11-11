import java.util.concurrent.Callable

class FindMaxVector(val array: List<Int>): Callable<Int> {
    override fun call(): Int {
        return array.max()!!
    }
}