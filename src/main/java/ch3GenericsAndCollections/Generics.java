package ch3GenericsAndCollections;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    // Generics are used to provide flexibility and reusability to classes
    // that can be used in multiple situtations but are otherwise bound to a single type
    // of class

    // An example is arrayList, where it can take any object as the type. So this is
    // an array list of strings
    List<String> lString = new ArrayList<String>();

    // in Java 8+ it is possible to omit the type on the right hand side
    // this infers the type from the left hand side
    List<String> lString1 = new ArrayList<>();








}
