package main.java.interfaces;

// 1. an interface cannot extend a class, only another interface
public interface Run extends Walk {
    public abstract boolean canHuntWhileRunning();
    abstract double getMaxSpeed();
}