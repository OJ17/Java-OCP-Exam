package ch7Concurrency;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicClasses {
    // Java also contains a number of "Atomic" classes. This has nothing to do with nuclear
    // which is derived from atoms. It derives from the transliteration of ATOM meaning
    // "Indivisible". By this definition, an atomic class is a way of ensuring that common
    // operations such as incrementing are completed as a indivisible unit, and not shared between
    // threads thereby avoiding concurrency issues that would otherwise result

    public static void main(String[] args) {

        AtomicBoolean aB = new AtomicBoolean(true);
        System.out.println(aB.get());
        System.out.println();

        System.out.println("Atomic integer");
        AtomicInteger aI = new AtomicInteger(10);
        System.out.println(aI);
        aI.getAndIncrement();
        System.out.println(aI);
        aI.getAndDecrement();
        System.out.println(aI);
        aI.addAndGet(10);
        System.out.println(aI);
        aI.getAndAdd(20);
        System.out.println(aI);
        // this get and add will only print 40, because it prints then sets.
        System.out.println(aI.getAndAdd(100));

        System.out.println();
        AtomicIntegerArray aIA = new AtomicIntegerArray(new int[]{1, 2, 3, 4, 5, 6});
        for (int i = 0; i < aIA.length(); i++) {
            System.out.println(aIA.get(i));
        }



    }

}
