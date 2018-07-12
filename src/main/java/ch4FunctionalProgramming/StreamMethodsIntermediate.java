package ch4FunctionalProgramming;

import org.omg.CORBA.INTERNAL;

import java.util.stream.Stream;

public class StreamMethodsIntermediate {

    // Streams come with a lot of intermediate operations
    // this class covers the main ones

    public static void main(String[] args) {
        // Filter - filters each element in a stream via a predicate
        Stream<String> filterStream = Stream.of("OK", "OKAY", "okOK");
        filterStream.filter(s -> s.endsWith("OK")).forEach(System.out::print);
        System.out.println();

        // distinct() - returns a stream with duplicates removed
        Stream<Integer> distStream = Stream.of(1,2,3,4,1,2,3,4);
        distStream.distinct().forEach(s ->  System.out.print(" distinct: " + s));
        System.out.println();

        // limit() - Limits the number of elements in a stream
        Stream<Integer> limitStream = Stream.of(1,2,3,4,4,5,5,6);
        limitStream.limit(3).forEach(s -> System.out.print(s + "limit"));

        // skip() & limit() - Skip skips(x) elements
        Stream<Integer> skipStream = Stream.of(1,2,3,4,5,6,6,7);
        limitStream.limit(3).skip(2).forEach(s -> System.out.print("limit skip: " + s));

        

    }
}
