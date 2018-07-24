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


    // this <T> is a generic method, it is often used on static methods
    // but can be used on non-static methods also
    public static <T> T genMethod(T t) {
        if(t instanceof ComparableDemo){
            t = (T) new ComparableDemo("nova",7,13);
        }
        return t;
    }


    public static void main(String[] args) {

        ComparableDemo cd = new ComparableDemo("name",
                1,40);
        ComparableDemo zwei = genMethod(cd);

        System.out.println("Pre method is: " + cd);

        System.out.println("post method is: " + zwei);



    }


}
