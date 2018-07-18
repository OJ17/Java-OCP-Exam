package ch7Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    // This is the preferred way of interacting with threads in Java

    public static void main(String[] args){

        ExecutorService service = null;

        try {
            // ExecutorService has a factory method constructor
            // this is called with: Executors.X()
            // since there is nonly one thread for this task, the results will be executed
            // in a predictable order
            service = Executors.newSingleThreadExecutor();
            service.execute(() -> System.out.println("Printing Zoo inventory"));
            service.execute(() -> {for(int i = 0; i < 3; i++)
                System.out.println("Printing record: " + i);}
            );
            service.execute(() -> System.out.println("Printing zoo inventory"));
            System.out.println("end");

        } finally {
            if(service != null)
                // this method does not stop any tasks that are submitted
                // to the executor service
                service.shutdown();

            // if you want to cancel all running and scheduled tasks
            // you can use the shutdownNow() method, which attempts to stop all
            // running tasks. However even with this there is no guarantee it will
            service.shutdownNow();
        }



    }

}
