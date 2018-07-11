package ch4FunctionalProgramming;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamMethodsBasic {

    public static void main(String[] args){
        List<String> lStream = new ArrayList<>(Arrays.asList("1","2","3"));
        // Generating streams
        Stream<String> empty = Stream.empty();
        Stream<Integer> singleElement = Stream.of(1);
        Stream<Integer> fromArray = Stream.of(1,2,3);
        Stream<String> fromListParallel = lStream.parallelStream();

        Map<String,Integer> map = new HashMap<>();
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        map.put("D",4);

        map.values().stream().peek(System.out::print).forEach(System.out::print);

        Predicate<Integer> pInt = s -> s > 0;

        // Stream terminal operations
        Stream<Integer> demoStream = Stream.of(1,2,3,4,5);
        // checks all the values match given predicate
        System.out.println(demoStream.allMatch(pInt));

        // checks for any match and returns boolean
        System.out.println(demoStream.anyMatch(pInt));

        // returns true if none of the values match predicate
        System.out.println(demoStream.noneMatch(pInt));



    }
}
