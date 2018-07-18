package ch7Concurrency;

import java.util.Arrays;
import java.util.stream.Stream;

public class ParallelStreamsDemo {

    public static void main(String[] args) {

        // A parallel stream is a stream that you can run by utilizing multiple threads
        // The main benefit is that is can provide significant performance improvements
        // over executing on a single thread
        Stream<Integer> sInt = Arrays.asList(1, 2, 3, 4, 5, 6, 7).stream();
        Stream<Integer> parallelStream = sInt.parallel();

        Stream<Integer> parallelStream2 = Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream();

        // this will print out 1 - 6 always
        System.out.println("concurrent stream output: ");
        Arrays.asList(1, 2, 3, 4, 5, 6).stream().forEach(s -> System.out.print(s + " "));

        System.out.println("\n");
        // This will print out 1 - 6 in random order. The reason is that multiple threads
        // are being used to process it, so there is no clear order which thread will run first
        System.out.println("parallel stream output:");
        parallelStream2.forEach(s -> System.out.print(s + " "));

        // you can use forEachOrdered() on a parallel stream to force it to order the results
        // this has a performance impact
        System.out.println("\nforEachOrdered parallelStream");
        Stream<Integer> pS3 = Arrays.asList(1,2,3,4,5,6).parallelStream();
        pS3.forEachOrdered(s -> System.out.println(s + " "));


    }

}
