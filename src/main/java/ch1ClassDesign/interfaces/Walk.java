package ch1ClassDesign.interfaces;

// ch1ClassDesign.interfaces cannot be marked final
// Intefaces cannot be instantiated directly
public interface Walk {
    boolean isQuadruped();
    abstract double getMaxSpeed();

}


