package ch4FunctionalProgramming;

import ch1AdvancedClassDesign.interfaces.Eagle;

import java.util.function.Predicate;

public class FunctionalInterfaces {

    public static void print(Eagle eagle, Predicate<Eagle> predicate){
        if(predicate.test(eagle)){
            System.out.println(eagle);
        }
    }

    // Predicate has 1 parameter,
    // and returns a boolean
    public static void main(String[] args){
        print(new Eagle(), s-> s.isQuadruped());



    }

}
