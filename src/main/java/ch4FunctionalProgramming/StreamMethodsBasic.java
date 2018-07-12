package ch4FunctionalProgramming;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.BinaryOperator;
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

        Stream<Integer> demoStream1 = Stream.of(1,2,3,4,5);
        // checks for any match and returns boolean
        System.out.println(demoStream1.anyMatch(pInt));

        Stream<Integer> demoStream2 = Stream.of(1,2,3,4,5);
        // returns true if none of the values match predicate
        System.out.println(demoStream2.noneMatch(pInt));

        // same as for(int x : ls){...);
        // calling this on a infinite stream does
        // not terminate
        Stream<Integer> demoStream3 = Stream.of(1,2,3,4,5);
        demoStream3.forEach(System.out::println);

        // reduce() combines a stream to a single object
        // e.g. 1 + 2 + 3 + 4 + 5 == 15, as per BinaryOperator below
        // It returns an optional
        Stream<Integer> demoStream4 = Stream.of(1,2,3,4,5);
        BinaryOperator<Integer> bo = (x,y) -> x + y;
        Optional<Integer> rs = demoStream4.reduce(bo);
        System.out.println("Reduce result is " + rs);

        // Collect() this is mutable reduction. E.g. that it changes the same
        // object in a similar way to StringBuilder, rather than like string
        // so it uses less memory
        Stream<String> stream = Stream.of("w","o","l","f");
        StringBuilder word = stream.collect(StringBuilder::new,
                StringBuilder::append, StringBuilder::append);
        // Collect has 3 parts Collect(Supplier, accumulator, combiner)
        // the first part Supplier, is the object that will store the results
        // the second part is the accumulator which adds data to the collection
        // the third part is the combiner, which adds the streams together again in
        // the case of parallel streams. Since there is a little more to remember for this
        // here is another collect() example
        Stream<String> fearwolf = Stream.of("f","e","a","r");
        // in this example, a new TreeSet is created, it adds all the elements, and the
        // addAll method will combine all of the component TreeSets in case of parallel executions
        TreeSet<String> ts = fearwolf.collect(TreeSet::new,TreeSet::add,TreeSet::addAll);




    }
}
