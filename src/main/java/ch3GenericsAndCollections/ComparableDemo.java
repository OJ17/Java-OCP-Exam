package ch3GenericsAndCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class ComparableDemo implements Comparable<ComparableDemo>{

    private String name;
    private int size;
    private int volume;

    public int getSize(){
        return this.size;
    }

    public int getVolume(){
        return this.volume;
    }

    public String getName(){
        return this.name;
    }

    // As part of the Comparable interface, a method
    // called compareTo is required. This enables objects to be compared
    // according to a given criteria
    public int compareTo(ComparableDemo x) {
        return name.compareTo(x.name);
    }

    public ComparableDemo(String name, int size, int volume){
        this.name = name;
        this.size = size;
        this.volume = volume;
    }

    @Override
    public String toString(){
        return "name: " + name + " size: " + size + " vol: " + volume;
    }

    public static void main(String[] args) {
        List<ComparableDemo> cDemo = new ArrayList<>();
        cDemo.add(new ComparableDemo("Yo",10,15));
        cDemo.add(new ComparableDemo("Hi",500,777755));
        cDemo.add(new ComparableDemo("Hi",5000,4000));
        // Despite ComparableDemo not being a inbuilt type it is
        // possible to sort the collection because it implements the
        // compareTo(cDemo) method. Without this method.
        // the error mesage is: "No instance of type variable T...
        // that conform to Comparable<? super T). i.e. that comparable is not
        // implemented
        Collections.sort(cDemo);
        System.out.println(cDemo);

        // 3 return types for comparable
        // a number < 0 is returned when the current object is larger
        // than the argument to compareTo()
        // below it returns -17. because that is the char difference between
        // H and Y. It has a - because H is 17 less in Char terms that Y
        System.out.println(cDemo.get(1)
                .compareTo(cDemo.get(2)));

        // a number == 0 when they are the same value
        System.out.println(cDemo.get(0).compareTo(cDemo.get(1)));

        // a number > 0 is returned when A isBigger than .compareTo(B)
        System.out.println(cDemo.get(2).compareTo(cDemo.get(1)));

        Comparator<ComparableDemo> bySize = new Comparator<ComparableDemo>() {
            public int compare(ComparableDemo c1, ComparableDemo c2) {
                return c1.getSize() - c2.getSize();
            }
        };












    }

}

