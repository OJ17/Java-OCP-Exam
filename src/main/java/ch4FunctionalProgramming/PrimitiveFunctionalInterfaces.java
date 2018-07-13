package ch4FunctionalProgramming;

import java.util.function.*;

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


        // Int primitive interfaces
        IntFunction<String> intF = x -> Double.toString(x);
        IntUnaryOperator iUO = s -> s;
        IntBinaryOperator iBO = (s,f) -> s;

        // long primitive interface
        LongFunction<Integer> lF = l -> (int) l;
        LongUnaryOperator lUO = s -> s;
        LongBinaryOperator lBO = (l,f) -> l;




    }
}
