package ch9NIO2;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesDemo {

    public static void main(String[] args) throws IOException {
        Path realPath = Paths.get("/users/dmt/Documents/JavaOCP/IOdemo.txt");

        // isSameFile() - checks that the path strings are equal, and if not checks
        System.out.println(Files.isSameFile(Paths.get(
                "/users/dmt/Documents/JavaOCP/IOdemo.txt")
                , realPath));
        // Expected to print true, seems java doesn't auto-relativize path names
        System.out.println(Files.isSameFile(Paths.get(
                "/users/dmt/fakedir/../Documents/JavaOCP/IOdemo.txt")
                ,Paths.get("/users/dmt/fakedir/../Documents/JavaOCP/IOdemo.txt"))
        );

        // this will create a directory world, in the directory hello
        // otherwise an error will be thrown
        //Files.createDirectory(Paths.get("hello/world"));
        Files.createDirectories(Paths.get("hello/world"));

        // .copy()
        try(InputStream is = new FileInputStream("/users/dmt/Documents/JavaOCP/IOdemo.txt");
        OutputStream out = new FileOutputStream("output-data-.txt")) {
            Files.copy(is,Paths.get("/users/dmt/Documents/JavaOCP/CopyCat.txt"));
        } catch (IOException e){

        }

        // Files.move()
        //Files.move(pathA,pathB)


        // Files.delete() - deletes files

        // Files.deleteIfExists() - checks if exists,then attempts delete



    }
}
