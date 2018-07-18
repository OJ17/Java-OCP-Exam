package ch4FunctionalProgramming;

import org.omg.CORBA.INTERNAL;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
        Stream<Integer> distStream = Stream.of(1, 2, 3, 4, 1, 2, 3, 4);
        distStream.distinct().forEach(s -> System.out.print(" distinct: " + s));
        System.out.println();

        // limit() - Limits the number of elements in a stream
        Stream<Integer> limitStream = Stream.of(1, 2, 3, 4, 4, 5, 5, 6);
        limitStream.limit(3).forEach(s -> System.out.println(s + "limit"));
        System.out.println();

        // skip() & limit() - Skip skips(x) elements
        Stream<Integer> skipStream = Stream.of(1, 2, 3, 4, 5, 6, 6, 7);
        skipStream.limit(3).skip(2).forEach(s -> System.out.print("limit skip: " + s));
        System.out.println();

        // The map function alters a stream, such as converting an object
        // to an object field: In this case it changes from Stream to int
        Stream<String> mapStream = Stream.of("fear", "Wolf", "Venom");
        mapStream.map(String::length).forEach(System.out::print);
        System.out.println();

        // flatMap() - takes in each element of the stream and
        // converts it to a single top level collection. e.g.
        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("Fire");
        List<String> oneZero = Arrays.asList("Fire wolf", "Hour Of Darkness");
        // here is a stream of lists of strings. All as separate elements
        Stream<List<String>> oneZeroo = Stream.of(zero, one, oneZero);
        oneZeroo.flatMap(m -> m.stream()).forEach(s -> System.out.print(
                " Flatmap " + s));
        System.out.println();

        // Sorted() - sorted method returns a stream with sorted elements
        // natural ordering is used in the absence of a comparator
        Stream<Integer> sortStream = Stream.of(4, 6, 8, 3, 2, 1, 57, 8);
        sortStream.sorted().forEach(System.out::print);
        System.out.println();

        // sorted() \W reverse
        Stream<Integer> reverseSorted = Stream.of(4, 6, 8, 3, 2, 1, 57, 8);
        reverseSorted.sorted(Comparator.reverseOrder()).forEach(
                System.out::print);
        System.out.println();

        // Peek() - often a debugging operation, prints out elements as they
        // are passing through the stream
        Stream<Integer> peekStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8);
        peekStream.filter(s -> s > 3).peek(System.out::print).count();
        System.out.println();

        // Stream intermediate methods can be chained to easily
        // attain complex behaviour
        Stream<String> s = Stream.of("a", "B", "C", "D", "D", "Yes", "OKAY", "good");
        s.map(x -> x.toUpperCase())
                .sorted()
                .distinct()
                .limit(3)
                .forEach(System.out::print);

    }
}
