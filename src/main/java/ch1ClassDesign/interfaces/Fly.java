package ch1ClassDesign.interfaces;

public interface Fly {
    public int getWingSpan() throws Exception;

    // 1. the compiler automatically adds public to all interface methods
    // Not true in Java 9+, but keep this in mind for the exam
    public static final int MAX_SPEED = 100;

    // an example of a default method. A default method does not require
    // the implementing class to write an implementation. If one is not
    // written the compiler will use this by default
    public default void land(){
        System.out.println("Animal is landing");
    }

    public static double calculateSpeed(float distance, double time){
        return distance / time;
    }
    // This method turns to public abstract...
    void toTheStars();

    //2. the compiler automatically adds abstract to all non-default, and
    // all non-static methods


}



