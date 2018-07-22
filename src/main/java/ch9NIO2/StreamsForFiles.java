package ch9NIO2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamsForFiles {


    public static void main(String[] args) {
        // walking a directory is a recursive file search that is performed by streams\
        // this code iterates over a file, and prints out the path of all the files
        // that end with .java
        Path p1 = Paths.get("");
        try {
            Files.walk(p1)
                    .filter(p -> p.toString().endsWith(".java"))
                    .forEach(System.out::println);
        } catch (IOException e) {

        }

        System.out.println("\n\n\n");

        // find
        Path p2 = Paths.get("");
        long dateFilter = 1420070400000l;
        try {
            Stream<Path> stream = Files.find(p2, 10,
                    (p, a) -> p.toString().endsWith(".java")
                            && a.lastModifiedTime().toMillis() > dateFilter);
            stream.forEach(System.out::println);

        } catch (IOException e) {

        }

        System.out.println("\n\n\n");

        // list - this code lists through a directory listing all the files
        // that are not directories it contains
        Path p3 = Paths.get("");
        try {
            Files.list(p2)
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toAbsolutePath())
                    .forEach(System.out::println);
        } catch (IOException e) {

        }

        // lines - printing file contents. You can use the usual collectors / filters
        // for processing what lines get printed / manipulated
        Path p4 = Paths.get("");
        try {
            Files.lines(p4).forEach(System.out::println);
        } catch (IOException e) {

        }


    }
}
