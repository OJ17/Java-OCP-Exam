package ch9NIO2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.time.Instant;

public class FileAttributesInfo {

    public static void main(String[] args) {

        try {
            Path pathRezz = Paths.get("/have/no/Fear.txt");
            Path pathRezz2 = Paths.get("/have/no/mind/Wolf.txt");
            Path p1 = Paths.get("/users/dmt/Documents/JavaOCP/IOdemo.txt");
            // this method checks if a file is hidden or not
            System.out.println(Files.isHidden(pathRezz));
            // does the file have read access?
            System.out.println(Files.isReadable(pathRezz));
            // is the file executable?
            System.out.println(Files.isExecutable(pathRezz));
            // Files.size() reads and returns the file length in byes
            System.out.println(Files.size(
                    p1)
            );
            // getLastModifiedtime()
            System.out.println(Files.getLastModifiedTime(p1));
            // setLastModifiedTime()
            Instant is = Instant.now();
            FileTime ft = FileTime.from(is);
            // this changes the file object on the file system,
            // and sets the last modified time to today
            System.out.println(Files.setLastModifiedTime(p1,ft));
            System.out.println(Files.getLastModifiedTime(p1));

            //getOwner()
            System.out.println(Files.getOwner(p1));

            // setOwner()
            UserPrincipal owner = FileSystems.getDefault()
                    .getUserPrincipalLookupService().lookupPrincipalByName("dmt");
            System.out.println(Files.setOwner(p1,owner));

            // Basic file attributes contains a listof the basic attributes of a file
            // e.g. name, isDirectory, lastModified, creationTime, etc.
            BasicFileAttributes basicFileAttributes = Files.readAttributes(p1, BasicFileAttributes.class);
            System.out.println("Creation time: " + basicFileAttributes.creationTime());
            System.out.println("Is regulat file: " + basicFileAttributes.isRegularFile());

            // BasicFileAtrributeView - this is used to modify a file's set of date time
            // values. You cannot modify other attributes directly
            BasicFileAttributeView view = Files.getFileAttributeView(p1,
                    BasicFileAttributeView.class);




        } catch (IOException e) {

        }


    }
}
