package ch8IO;

import java.io.Console;
import java.io.IOException;

public class ConsoleClass {
    // The console close is four System.in and .out operations

    public static void main(String[] args) {
        // Console is not available on all platforms. Hence the null check below
        // on most IDEs Console is not accessible!
        Console console = System.console();
        if (console != null) {
            String userInput = console.readLine();
            console.writer().println("You entered the following: " + userInput);
            try
            {
                // the console has access to the PrintReader and
                // PrintWriter classses
                console.reader().mark(1);
                console.writer().println("OK");
                // it also has printf() and format() like PrintReader / Writer

                // it is recommended to call flish prior to readLine() or
                // readPassword() methods to ensure no data is pending during the
                // read
                console.flush();
                console.readLine();
                // Read password disables echoing, and returns a Character[] this is for
                // security reasons related to the string pool. It is otherwise similar
                // to readline
                console.readPassword();




            } catch(IOException e){

            }
        }


    }
}
