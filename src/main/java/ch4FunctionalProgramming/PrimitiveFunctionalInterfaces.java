package ch4FunctionalProgramming;

import java.sql.SQLOutput;
import java.util.function.*;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveFunctionalInterfaces {

    public static void main(String[] args) {
        // Most of the functional interfaces covered
        // also have a primitive equivalent
        //Double primitive interfaces:
        // this function takes a double and returns string
        DoubleFunction<String> dToS = s -> Double.toString(s);

        DoubleUnaryOperator dUO = s -> s;

        DoubleBinaryOperator bUO = (s, u) -> s;

        // this is a primitive only functional interface
        // it converts the <T> value to a double
        ToDoubleFunction<String> tDF = s -> Double.parseDouble(s);

        // converts double to int
        DoubleToIntFunction dTIF = s -> (int) s;
        DoubleToLongFunction dTLF = s -> (long) s;


        // Int primitive interfaces
        // IntFunction<T> converts int to <T>
        IntFunction<String> intF = x -> Integer.toString(x);
        IntUnaryOperator iUO = s -> s;
        IntBinaryOperator iBO = (s,f) -> s;
        // ToIntFunction<T> converts <T> to int
        ToIntFunction<String> tIF = x -> Integer.parseInt(x);
        IntToLongFunction iTLF = x -> (long) x;
        IntToDoubleFunction iTDF = x -> (double) x;


        // long primitive interface
        LongFunction<Integer> lF = l -> (int) l;
        LongUnaryOperator lUO = s -> s;
        LongBinaryOperator lBO = (l,f) -> l;
        // ToLongFunction converts <T> to long
        ToLongFunction<String> tLF = l -> Long.parseLong(l);
        LongToIntFunction lTIF = s -> (int) s;
        LongToDoubleFunction lTDF = s -> (double) s;

        LongStream lStream = LongStream.of(11L,22L);
        Stream<String> stringStream = Stream.of("11","12");
        System.out.println("Long to double function: " + lTDF.applyAsDouble(2L));
        System.out.println("Long to Int Function: " +  lTIF.applyAsInt(2L));
        System.out.println("To Long Function: " + tLF.applyAsLong("3"));

        // this has two input parameters of object and double
        ObjDoubleConsumer<String> oTDF = (o,d)-> System.out.println("obj1Double: null");
        ObjIntConsumer<String> oIT = (o,i) -> System.out.println("obj2int: null");
        ObjLongConsumer<String> oLT = (o,l) -> System.out.println("obj2l: null");


    }
}
