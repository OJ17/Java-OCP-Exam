package ch4FunctionalProgramming;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStreams {
    // PrimitiveStreams are for int, double,
    // and long. They are required since the
    // ordinary streams return an object

    public static void main(String[] args) {

        // IntStream example
        IntStream is = IntStream.of(1, 2, 3, 4);
        // OptionalDouble returns a double primitve
        // Optional<Double> returns a Double object
        OptionalDouble od = is.average();
        System.out.println(od.getAsDouble());

        // Primitive Streams can also be useful
        // for the built in methods such as
        // .average(), .sum() which can't work on
        // non numeric types


        // LongStream example
        LongStream ls = LongStream.of(1L,2L,3L);


        // DoubleStream example
        DoubleStream ds = DoubleStream.empty();
        DoubleStream ds1 = DoubleStream.of(3.14,1.0,1.20);
        // generates a stream of random doubles
        DoubleStream random  = DoubleStream.generate(Math::random);
        // generates a stre
        DoubleStream fractions = DoubleStream.iterate(.5,d-> d / 2);






    }
}
