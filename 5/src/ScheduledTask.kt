import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


class ScheduledTask(val date: Calendar, val task: Runnable): Runnable{
    override fun run() {
        val scheduledExecutorService = Executors.newScheduledThreadPool(5)
        val seconds = (date.timeInMillis - Calendar.getInstance().timeInMillis)/1000
        scheduledExecutorService.schedule(task, seconds, TimeUnit.SECONDS)
        scheduledExecutorService.shutdown()
    }
}