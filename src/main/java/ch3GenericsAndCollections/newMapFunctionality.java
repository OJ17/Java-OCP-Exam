package ch3GenericsAndCollections;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class newMapFunctionality {

    public static void main(String[] args) {
        // Three new methods were added to the Map interface in Java
        // below is an example of how to use some of them

        Map<String, String> magazines = new HashMap<>();
        magazines.put("List in the echo", "Links apart");
        magazines.put("Points of Authority", "The pace is too fast");
        magazines.put("One Step closer", "To the edge");
        magazines.put("In the end", null);

        System.out.println(magazines);

        System.out.println();
        // putIfAbsent(); - since the key is the same, this will not be added
        magazines.putIfAbsent("List in the echo", "One last lie for me to see through");
        System.out.println(magazines);

        System.out.println();
        // merge() - Allows adding logic to the problem of what to choose.
        // in this example you simple choose the longest value
        BiFunction<String, String, String> mapper =
                (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
        String shinobi = magazines.merge("List in the echo",
                "these words get lost in the echo", mapper);
        String benz = magazines.merge("Points of Authority",
                "linking parks", mapper);
        // since the value is null, then the mapping function isn't called for the below
        // if it were a NullPoiter would run
        String edgeLord = magazines.merge("In the end",
                "it doesn't even matter", mapper);
        System.out.println(magazines);


        Map<String, Integer> liesMadeOfPulp = new HashMap<>();
        liesMadeOfPulp.put("clocks work", 8);
        liesMadeOfPulp.put("people dream", 5);
        liesMadeOfPulp.put("Some say I'm a dreamer", 23432);

        BiFunction<String,Integer,Integer> mapr = (k,v) -> v +1;
        Integer fire = liesMadeOfPulp.computeIfPresent("clocks work",mapr);
        Integer hellFire = liesMadeOfPulp.computeIfPresent("I'm totally over it",mapr);

        System.out.println();
        System.out.println(liesMadeOfPulp);
        System.out.println(fire);
        // this prints null because it is not present, so the method does not compute
        System.out.println(hellFire);
        System.out.println();


        Map<String, Integer> Candy = new HashMap<>();
        liesMadeOfPulp.put("candyfloss", 8);
        liesMadeOfPulp.put("Candy sweet", 5);
        liesMadeOfPulp.put("Eye Candy", 23432);
        // computeIfPresent takes a Function, not a BiFunction
        Function<String,Integer> maprr = (k) -> null;
        Integer fireBall = liesMadeOfPulp.computeIfAbsent("candyfloss",maprr);
        Integer dragonBallZ = liesMadeOfPulp.computeIfAbsent("ICON",maprr);

        // since candyfloss is in the list, it does not compute the removal of it
        System.out.println(fireBall);
        // otherwise this would return maprr return value
        System.out.println(dragonBallZ);










    }


}
