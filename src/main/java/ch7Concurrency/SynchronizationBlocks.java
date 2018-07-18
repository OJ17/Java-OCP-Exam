package ch7Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizationBlocks implements Runnable{

    private static int syncCount = 0;

    // This is an example of how using Synchronization blocks can help resolve
    // multi-threaded read write issues
    public void run() {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);

            SynchronizationBlocks sK = new ch7Concurrency.SynchronizationBlocks();
            // submit 10 executions to the threadpool
            for (int i = 0; i < 10; i++)
                service.submit(() -> sK.incrementAndReport());
        } finally {
            if (service != null)
                service.shutdown();
        }
    }

    private void incrementAndReport() {
        // This is the benefit of the Synchronization block. By putting the Incrementer
        // inside a synchronized(this) block, then it ensure that the method can only
        // be accessed by a single thread at a given time, thereby ensuring a consistent
        // stream of results
        synchronized (this) {
            System.out.println((++syncCount) + " ");
        }
    }

    public static void main(String[] args) {
        (new Thread(new SynchronizationBlocks())).start();
        (new Thread(new SynchronizationBlocks())).start();
    }

}
