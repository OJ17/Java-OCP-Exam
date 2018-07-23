package ch3GenericsAndCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo implements Comparable<ComparableDemo> {

    @Override
    public int compareTo(ComparableDemo o) {
        return 1;
    }

    public static void main(String[] args) {


        List<ComparableDemo> cDemo = new ArrayList<>();
        cDemo.add(new ComparableDemo("Yo",10,15));
        cDemo.add(new ComparableDemo("Hi",500,777755));
        cDemo.add(new ComparableDemo("Hi",5000,4000));

        // Comparator is useful when you wantto specify a sort order without using the compareTo() method

        // comparator enables you to implement multiple different logics
        // for sorting the same class. Since Comparable uses compareTo() it is restricted
        // to a single method
        Comparator<ComparableDemo> bySize = new Comparator<ComparableDemo>() {
            public int compare(ComparableDemo c1, ComparableDemo c2) {
                return c1.getSize() - c2.getSize();
            }
        };

        // this can also be writen as a lambda expression since it is a functional interface
        Comparator<ComparableDemo> bySizeA = (c1,c2) -> c1.getSize()-c2.getSize();

        // below is an example of how a Comparator can be used to sort by different attributes
        // and passing it into the sort method. This prevents sorting being restricted to the
        // so called natural order implemented by the Comparable / compareTo() method.

        Comparator<ComparableDemo> byName = (n1,n2) -> n1.getName().compareTo(n2.getName());

        Comparator<ComparableDemo> bySize1 = (c1,c2) -> c1.getSize()-c2.getSize();

        Comparator<ComparableDemo> byVolume = (c1,c2) -> c1.getVolume() - c2.getVolume();

        Collections.sort(cDemo,byName);
        System.out.println("by Name: " + cDemo);

        Collections.sort(cDemo,bySize1);
        System.out.println("by Size: " + cDemo);

        Collections.sort(cDemo,byVolume);
        System.out.println("by Volume: " + cDemo);



    }
}
