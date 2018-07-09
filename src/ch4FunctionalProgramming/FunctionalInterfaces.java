package ch4FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfaces {


    public FunctionalInterfaces() {
    }

    public static void main(String args[]){

    Predicate<String> predLambda = s -> s.endsWith("hi");

    List<String> lString = new ArrayList<String>();
    lString.add("hi");
    lString.add("Yes");
    lString.add("Goon");
    lString.add("hi");

    //isValid(predLambda, lString);

    long count = lString.stream().count();
    lString.stream().filter(predLambda).forEach(s -> System.out.println(s));
    System.out.println(count);
    }

    public static boolean isValid(Predicate<String> lambda, List<String> lStr){
        boolean isVal = false;
        lStr.forEach(s -> System.out.println(s));

        return isVal;
    }
}
