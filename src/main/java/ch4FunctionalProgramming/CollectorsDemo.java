package ch4FunctionalProgramming;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsDemo {

    //  Collectors are part of the Stream API in Java, and provide a way to collect results from
    // stream operations
    public static void main(String[] args){

        // basic collector example
        Stream<String> stringStream = Stream.of("Fear","Wolf","over");
        // collector is passed to the collect object, and is useless alone
        String result = stringStream.collect(Collectors.joining(", "));
        System.out.println(result);

        // Collectors.averagingDouble gets the average of the passed values
        Stream<String> stringStream1 = Stream.of("Fear","Wolf","hopeful");
        Double dRES = stringStream1.collect(Collectors.averagingDouble(String::length));
        System.out.println(dRES);

        // Collectors and maps
        // the below example shows a stream converted to a map where
        // s -> s is the key, and String::length is the value
        Stream<String> apiMap = Stream.of("Fear","Wolf","Life");
        // Function.identity() == s -> s
        Map<String,Integer> map = apiMap.collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(map);

        Stream<String> mapStream = Stream.of("Fear","Wolf","Loathing");
        Map<Integer,String> realMap = mapStream.collect(Collectors.toMap(
                String::length,
                Function.identity(),
                (s1,s2) -> s1 + "," + s2));
        System.out.println("Map with comparator " + realMap);
        System.out.println(realMap.getClass());

        Stream<String> mapStream1 = Stream.of("Fear","Wolf","Loathing");
        Map<Integer,String> realMap1 = mapStream1.collect(Collectors.toMap(
                String::length,
                Function.identity(),
                (s1,s2) -> s1 + "," + s2,TreeMap::new));
        System.out.println("Map with comparator and TreeMap: " + realMap);
        System.out.println(realMap.getClass());

        // Grouping
        // grouping returns a collection (aka group) as the value based on the key
        // in this case it returns two groups 4=fear,wolf, and 8=loathing
        // the generic will be Map<T,Collection<T>>
        Stream<String> mapStream2 = Stream.of("Fear","Wolf","Loathing");
        Map<Integer,List<String>> realMap2 = mapStream2.collect(
                Collectors.groupingBy(String::length)
        );
        System.out.println("Map with comparator and TreeMap: " + realMap);
        System.out.println(realMap.getClass());



    }


}
