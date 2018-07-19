package ch8IO;

import java.io.File;

public class FileDemo {


    public static void main(String[] args) {

        // Linux / mac paths are delimited with / and instead of C:\ an absolute
        // path starts with / like below:
        File file = new File("/usr/Documents/Java OCP/IODemo.txt");

        // Since Java is WORA, you can get language agnostic delimiter via
        System.out.println(System.getProperty("file.separator"));
        // or
        System.out.println(File.separator);
        




    }

}
