package ch7Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedKeyword implements Runnable {

    public void run() {
        ExecutorService service = null;
        try {
            // creates a fixed threadpool of 20 threads. Fixed means it cannot
            // go over the parameter passed
            service = Executors.newFixedThreadPool(20);

            SynchronizedKeyword sK = new SynchronizedKeyword();
            // submit 10 executions to the threadpool
            for (int i = 0; i < 10; i++)
                service.submit(() -> sK.incrementAndReport());
        } finally {
            if (service != null)
                service.shutdown();
        }
    }


    public synchronized void demoSync(){
        System.out.println("This is an example of using Synchronized in a method");
    }

    // this is deliberately static, to demonstrate the problem that is caused by
    // synchronization. When this code is run on two threads, you can see that
    // at times they counter is not iterated, This is because
    private static int syncCount = 0;

    private void incrementAndReport() {
        System.out.println((++syncCount) + " ");
    }

    public static void main(String[] args) {
        (new Thread(new SynchronizedKeyword())).start();
        (new Thread(new SynchronizedKeyword())).start();

    }
}
