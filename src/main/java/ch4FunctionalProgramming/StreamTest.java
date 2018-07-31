package ch4FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args){
        // Each stream can only be used once. This works
        List<Double> dList = Arrays.asList(10.0,12.0);
        dList.stream().forEach(x -> { x = x+10;});
        dList.stream().forEach(d -> System.out.println(d));

        // the second terminal operator (here foreach), will
        // throw an error when ran because the stream has already
        // been operated upon
        Stream<Double> dStream = dList.stream();
        dStream.forEach(x -> {x+= 10;});
        dStream.forEach(x -> {x+= 10;});


    }

}
