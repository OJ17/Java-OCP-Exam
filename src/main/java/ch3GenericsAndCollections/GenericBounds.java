package ch3GenericsAndCollections;

import java.util.ArrayList;
import java.util.List;

public class GenericBounds {

    public static void printList(List<Object> list){
        for(Object x: list) System.out.print(x);
    }

    // There are different types of Bounds relating
    // to Generic types. This restricts which types can be used in a
    // wildcard position.
    public static void main(String[] args) {

        // ? - Unbounded wildcard. This is a wildcard generic type
        // it means any type is OK.
        List<?> l = new ArrayList<String>();


        // why is it required? As you can see here,  the commented lines
        // will not compile as long as List<String> is not of the specific
        // type requested, here object.

//        List<String> keywords = new ArrayList<>();
//        keywords.add("Java");
//        printList(keywords);

        // instead by using "?" or a generic type, you can add any type to it
        List<?> keywordsGen = new ArrayList<String>();


        // ? extends type - Wildcard with uppper bound
        List<? extends Exception> lEx = new ArrayList<RuntimeException>();

        // ? super type - Wildcard with lower bound
        List<? super Exception> lSuper = new ArrayList<Object>();



    }
}
