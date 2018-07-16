package ch6ExceptionsAndAssertions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ExceptionsBasics {

    public static void main(String[]args) {
        try {
            Path path = Paths.get("FearWolfPath.txt");
            String text = new String(Files.readAllBytes(path));
            LocalDate date = LocalDate.parse(text);
            // below is the Syntax for the multi-catch block
            // it is intendend to be used with unrelated exception
        } catch (DateTimeParseException | IOException e){
            e.printStackTrace();
            // it is also illegal to redeclare an exception (e), in a
            // multi-catch block
           // e = new RuntimeException();
        }
        //if you use a related on then it will not compile e.g.
        //catch(FileNotFoundException | IOException x){

        //}


        // Try with resources Demo
        // Everything in the resources block should implement the AutoCloseable
        // Interface.

    }

    // throws is in the method declaration i.e. throws Throwable
    public String getDataFromDatabase() throws SQLException {
        // when you throw an exception instance, you use throw instead
        throw new UnsupportedOperationException();
    }



}

// an example of a custom exception
class CustomException extends Exception {

    public CustomException() {
        super();
    }

    public CustomException(Exception e){
        super(e);
    }

    public CustomException(String message) {
        super(message);
    }

}

// this is another more specifc custom exception
class FearWolfLivesForever extends FileNotFoundException {

}


