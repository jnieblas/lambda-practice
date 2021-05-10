import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnablePractice {
    /** Runnable Interface */
    Runnable r = new Runnable() {
        public void run() {
            int i = 0;
            // Short hand for iteration over while loop
            while (i++ < 10) {
                System.out.println("it works!");
            }
        }
    };

    /** With Lambda */
    Runnable rl = () -> {
        int i = 0;
        // Short hand for iteration over while loop
        while (i++ < 10)
            System.out.println("Lambda time #" + i);
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

        ExecutorService es2 = Executors.newSingleThreadExecutor();
        // execute w/ lambda, shutdown again
        es2.execute(s.rl);
        es2.shutdown();
    }
}