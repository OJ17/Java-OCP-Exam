package ch7Concurrency;

import ch1ClassDesign.interfaces.Run;

public class RunnableBasics implements Runnable {

    // Runnable is an interface that requires a void run() method to be implemented
    // when the .start() method is called on it, then it runs this method.
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Printing record" + i);
        }
    }

    public static void main(String[] args) {

        // order to execute a runnable on a second thread, then you need to
        // pass in the object class into the Thread() class constructor and
        // run the start method on it.
        (new Thread(new RunnableBasics())).start();


    }


}
