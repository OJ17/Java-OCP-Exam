package ch8IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileDemo {


    public static void main(String[] args) {

        // Linux / mac paths are delimited with / and instead of C:\ an absolute
        // path starts with / like below:
        File file = new File("/users/dmt/Documents/JavaOCP/IODemo.txt");

        // By creating a file object with a path, it doesn't create a new file
        // in Java. You can see this will print false despite the code above
        System.out.println("Does file exist? " + file.exists());

        // some common method on File objects
        System.out.println("absolute path: " + file.getAbsolutePath());

        System.out.println("is Directory?: " + file.isDirectory());

        System.out.println("is it a file (not dir)? " + file.isFile());

        System.out.println("Last modified date: " + file.lastModified());

        System.out.println("File deleted " + file.delete());

        // this renames the file denoted by the path?
        System.out.println(file.renameTo(file));

        System.out.println("Make directory: " + file.mkdir());
        File iODir = new File("/users/dmt/Documents/JavaOCP/IODemo.txt");

        System.out.println("is new Dir dir? :" + iODir.isDirectory());

        System.out.println("Deleting new DIR: " + iODir.delete());
        File fileReplacement = new File("/users/dmt/Documents/JavaOCP/IODemo.txt");
        // Create a new file on the file system using a file writer. If it doesn't exist
        // then it is created
        try (
                FileWriter fileWriter = new FileWriter(fileReplacement);) {
            fileWriter.write("iotxt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Make directories: " + file.mkdirs());

        System.out.println("Parent is: " + file.getParent());
        File dir = new File("/usr/Documents");
        System.out.println("List of files in Dir: " + file.listFiles());

        // Since Java is WORA, you can get language agnostic delimiter via
        System.getProperty("file.separator");
        // or
        System.out.println("file separator is: " + File.separator);


    }

}
