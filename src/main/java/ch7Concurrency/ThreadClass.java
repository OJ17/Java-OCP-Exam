package ch7Concurrency;

import ch1ClassDesign.interfaces.Run;

public class ThreadClass extends Thread {
    // the thread class can be extended in order to run a class on
    // a new thread
    // it also contains a run method, which can be overwritten by the subclass

    public void run() {
        System.out.println("Printing Zoo inventory");
        // since this already inherits from thread then when you call it
        // it is not required to pass in the object class to a Thread
        // constructor
    }

    public static void main(String[] args) {
        (new ThreadClass()).start();
        (new Thread(new RunnableBasics())).start();
        (new ThreadClass()).start();
        (new Thread(new RunnableBasics())).start();
        System.out.println("end");
    }

}
