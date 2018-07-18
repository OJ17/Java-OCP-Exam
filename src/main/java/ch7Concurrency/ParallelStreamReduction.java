package ch7Concurrency;

import java.util.Arrays;

public class ParallelStreamReduction {


    public static void main(String[] args) {

        // Reduce operations on streams
        // this reduce opearation has 3 parts the Identity, the accumulator,
        // and the combiner.
        System.out.println(Arrays.asList('w','o','l','f')
                .stream()
                .reduce("",(c,s1) -> c + s1,
                        (s2,s3) -> s2 + s3));

        // Reduce operations on parallel streams follow the same logic, but they are
        // subject to a number of constraints





    }

}
