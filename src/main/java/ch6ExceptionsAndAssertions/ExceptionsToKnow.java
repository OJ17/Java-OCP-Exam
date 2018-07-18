package ch6ExceptionsAndAssertions;

import java.util.List;

public class ExceptionsToKnow {

    public int eCounter = 7;

    public static void main(String[] args) {

        // OCP Exceptions:

        // java.text.ParseException
        // this is similar to a NumberFormatException

        /// NIO.2 errors
        // java.io.IOException
        // java.io.FileNotFoundException
        // java.io.NotSerializableException

        // Exception related to SQL work. A checked exception
        // java.sql.SQLException

        // Trying to store wrong type of data in an array
        // java.lang.ArrayStoreException

        // Receiving an invalid format string for a date
        // java.time.DateTimeFormatException

        // Trying to access a key or resource bundle that doesn't exist
        // java.util.MissingResourceException

        // Attempting to run an invalid operation in collections and concurrency
        // java.lang.IllegalSTateException
        // java.lang.UnsupportedOperationException


    }


    public static void nPE(ExceptionsToKnow e) {
        e.eCounter = 10;
    }


    public static void OCAExceptions() {

        //ArihtmeticException - divide by zero exception
        int x = 3 / 0;

        // Thrown by the JVM when accessing illegal index. i.e.
        // ArrayIndexOutOfBoundsException
        int[] arr = new int[5];
        int z = arr[6];

        // ClassCastException - Thrown when attempting to cast to incompatible type
        // Canine c = new Canine();
        // Cat kitty = (Cat) c;

        // IllegalArgumentException
        // an example of an illegal argument is passing in a minus number
        // to an age field
        int age = -3;
        if (age < 0) {
            throw new IllegalArgumentException();
        }

        // NullPointerException
        // this happens when an object reference is null
        nPE(null);

        // NumberFormatException. This is when you try to parse a String
        // but the String does not have numeric type
        Integer.parseInt("t4");

    }
}


