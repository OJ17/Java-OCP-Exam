package ch2DesignPatternsAndPrinciples;

// A singleton is a class that you can only make one instance of
// A private constructor is required
// and a static instance called by getInstance() method
// this singleton implements lazy loading, to minimize resource wastage

public class SingletonDemo {

    private static SingletonDemo instance;

    private int TotalClasses;

    private SingletonDemo() {

    }

    public SingletonDemo getInstance() {
        if (instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }

    public synchronized boolean isTotalEven(int val) {
        return val % 2 == 0;
    }

}
