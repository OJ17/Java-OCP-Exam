package ch4FunctionalProgramming;

import java.util.Optional;
import java.util.function.Supplier;

public class Optionals {


    // this method returns Optional<Double> when the scores are
    // calculated. It returns an empty optioan if the array passed
    // in is empty.
    public static Optional<Double> getDouble(int... intarr) {
        if (intarr.length == 0) {
            return Optional.empty();
        }
        int sum = 0;
        for(int x : intarr) sum += x;
        return Optional.of((double) sum / intarr.length);
    }

    // The main benefit of optionals is to avoid dealing with
    // null pointer exceptions that break the program


    public static void main(String[] args) throws Throwable {
        Optional<Double> opt = getDouble(90, 100);
        if(opt.isPresent()){
            System.out.println(opt.get());
        }
        Supplier<Double> sD = () -> 3.14;
        System.out.println(opt.orElseGet(sD));
        // ofNullable, if values sD is null, then
        // return Optioanl.empty()
        Optional o = Optional.ofNullable(sD);
        // This says, get optional, or else if it is
        // null, then return 3.14 instead
        o.orElse(3.14);
        // this says get o(v), else call supplier
        o.orElseGet(sD);

        o.orElseThrow(() -> new ArithmeticException());


    }
}

