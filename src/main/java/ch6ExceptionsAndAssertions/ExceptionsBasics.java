package ch6ExceptionsAndAssertions;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ExceptionsBasics {

    public static void main(String[] args) throws IOException {
        try {
            Path path = Paths.get("FearWolfPath.txt");
            String text = new String(Files.readAllBytes(path));
            LocalDate date = LocalDate.parse(text);
            // below is the Syntax for the multi-catch block
            // it is intendend to be used with unrelated exception
        } catch (DateTimeParseException | IOException e) {
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
        // this has the try(){} syntax. An explicit catch or finally are not required
        Path path1 = Paths.get("/usr/lib");
        Path path2 = Paths.get("/usr/lib/ok");
        try (BufferedReader r = Files.newBufferedReader(path1);
             BufferedWriter w = Files.newBufferedWriter(path2)) {
            // when closing resources they are closed in the reverse order
            // that they were instantiated in
        }

        // in order to be used in the () section of a try \w resources
        // it is required to use the AutoCloseable interface
        // public void close() throws Exception;


    }

    // throws is in the method declaration i.e. throws Throwable
    public String getDataFromDatabase() throws SQLException {
        // when you throw an exception instance, you use throw instead
        throw new UnsupportedOperationException();
    }


}


