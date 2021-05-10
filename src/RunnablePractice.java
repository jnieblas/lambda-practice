import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnablePractice {
    /** Runnable Interface */
    Runnable r = () -> {
        int i = 0;
        // Short hand for iteration over while loop
        while (i++ < 10)
            System.out.println("it works!");
    };
}


class RunnableDriver {
    public static void main(String[] args) {
        RunnablePractice s = new RunnablePractice();
        // Build ExecutorService
        ExecutorService es = Executors.newSingleThreadExecutor();
        // execute our runnable
        es.execute(s.r);
        // shut down the service
        es.shutdown();
    }
}