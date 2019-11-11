import java.util.concurrent.Callable

class SumLine(val line: List<Int>): Callable<Int>{
    override fun call(): Int {
        return line.sum()
    }

}