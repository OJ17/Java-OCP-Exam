package ch8IO;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintClasses {

    public static void main(String[] args) {
        // the PrintReader and PrintWriter clases format a java object
        // and use it in a text based stream
        // There is also the PrintStream class,which is similar to an output stream
        // System.out and System.err are PrintStream objects
        // PrintStream inherits from OutputStream and PrintWriter inherits from Writer
        try (PrintWriter out = new PrintWriter("demo.log");) {
            out.print(5); // PrintWriter method
            out.write(String.valueOf(5)); // Writer method

            out.print(2.0); // PrintWriter method
            out.write(String.valueOf(2.0)); // Writer method

            AClassToSerialize aClassToSerialize = new AClassToSerialize("4",4,'x');
            out.print(aClassToSerialize); // PrintWriter method
            // writer method
            out.write(aClassToSerialize==null ? "null": aClassToSerialize.toString());

            // println can be used without parameters but is otherwise identical
            out.println();

            // there are also format() and printf() methods
            out.format("this is 10.1 and a format example");

            out.printf("It may ran 21.2 more inches this year");





        } catch (FileNotFoundException e) {

        }

    }


}
