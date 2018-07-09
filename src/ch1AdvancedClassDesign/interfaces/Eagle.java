package ch1AdvancedClassDesign.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//1. a class cannot extend an interface. It must implement it.
// you can implement multiple interfaces at once
public class Eagle implements Fly,Run,Walk{

    // There are rules on how an interface can be implemented
    // 1. An method implemented from an interface
    // cannot have an access modifier more restrictive
    // than specified within the interface
    // so deleting public here causes compilation error
    public int getWingSpan(){
        return 15;
    }

    public void land(){
        System.out.println("this is overridden from Fly default");
    }

    public void toTheStars(){
        System.out.println("Lil Peep says ok");
    }

    public boolean isQuadruped(){
        return true;
    }

    public double getMaxSpeed(){
        return 1.1111;
    }

    public boolean canHuntWhileRunning(){
        return true;
    }

    private static void functionalX(Eagle e, Functional<Eagle> f){
        System.out.println("Called from Lambda");
    }

    public static void main(String[] args) throws Exception {
        // example of using custom interface
        Functional<Eagle> fnc = x -> System.out.println();
        functionalX(new Eagle(),fnc);

        // Example of using default interface in lambda expression
        Predicate<String> p = x -> x.length() > 2;
        List<String> list = Arrays.asList("A","B","CA","DA","E");
        list.stream().allMatch(p);

        // Inteface instantiation by class
        Fly f = new Eagle();
        // Interface instantiation by anonymous class
        Fly fly = new Fly(){
            public void toTheStars(){
                System.out.println("This guy codes");
            }
            public int getWingSpan(){
                return 10;
            };
        };
        f.getWingSpan();
        f.land();
        System.out.println(fly.getWingSpan());
        // static method can be reference without instance / implements
        Fly.calculateSpeed(10,5);
    }
}
