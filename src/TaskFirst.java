import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskFirst {
    public static void main(String[] args) {
        ScheduledExecutorService schService = Executors.newScheduledThreadPool(2);
        long  sec = System.currentTimeMillis()/1000;
        schService.scheduleAtFixedRate(()->System.out.println("Пройшло "+ (System.currentTimeMillis()/1000-sec) + " sec")
                ,1,1, TimeUnit.SECONDS);
        schService.scheduleAtFixedRate(()->System.out.println("Минуло "+ (System.currentTimeMillis()/1000-sec) + " sec")
                ,5,5, TimeUnit.SECONDS);
    }
}
