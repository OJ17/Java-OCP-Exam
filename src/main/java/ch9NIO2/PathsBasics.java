package ch9NIO2;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsBasics {

    public static void main(String[] args) throws URISyntaxException, IOException {
        // relative path on Mac / Linux
        Path path1 = Paths.get("fear/wolf.png");

        // windows absolute path, note the double backslashes
        // due to the \ escape charater
        Path path2 = Paths.get("C:\\windows\\relative\\path");

        Path path3 = Paths.get("/this/is/absolute/macLinux");

        // Paths can be created with arrays of Strings also. e.g.
        Path path1Strings = Paths.get("fear", "wolf.png");
        Path path2Strings = Paths.get("C:/", "windows", "relative", "path");

        // n.b. that it is Paths.get not Path.get

        // Paths can also be constructed via a URI
        // URI's must reference an aboslute path, or they will throw a
        // URISyntaxException
        Path pathURI = Paths.get(new URI("file://" + "/fear/wolf.png"));

        // also you can use the FileSystems factory class to get a path
        Path path1FileSystem = FileSystems.getDefault().getPath("fear/wolf.png");

        // there is also a toFile method that converts a path to a file
        path1FileSystem.toFile();

        // Optional arguments as part of Files

        // a symbolic link is like a shortcut, to another actual file.
        // NOFOLLOW_LINKS - if provided, symbolic links will not be traversed

        //FOLLOW_LINKS - If provided, symbolic links when encountered will be traversed

        // COPY_ATTRIBUTES - If provided, all metadata will be copied with it

        // REPLACE_EXISTING - If provided, it will overwrite the existing file

        // ATOMIC_MOVE - Performed in an atomic manner, ensuring and process
        // is completed as a single unit


        Path path1X = Paths.get("/user/dmt/Documents/JavaOCP/fearwolf.txt");

        for (int i = 0; i < path1X.getNameCount(); i++) {
            // getName(i) prints out each component of the file path
            // e.g. comp1 = fear, comp2 = wolf.png  etc. it is zero indexed
            System.out.println("The path name is: " + path1X.getName(i));
        }

        System.out.println("Filename is: " + path1X.getFileName());

        System.out.println("Root is: " + path1X.getRoot());
        Path currentParent = path1X;
        while((currentParent = currentParent.getParent()) != null){
            System.out.println("    Current parent is: " + currentParent);
        }

        System.out.println("Path1X is Aboslute? " + path1X.isAbsolute());
        System.out.println("Path1X get absolute path: " + path1X.toAbsolutePath());

        Path relativePath = Paths.get("Relative/path/name.txt");
        System.out.println("relativePath is Absolute? " + relativePath.isAbsolute());
        System.out.println("relativePath get abs path " + relativePath.toAbsolutePath());

        // subpath elements
        // if the indexes are out of range then an IllegalArgumentException
        // will be thrown
        System.out.println("Subpath from 0 to 3: " + path1X.subpath(0,3));
        System.out.println("Subpath from 1 to 3: " + path1X.subpath(1,3));

        // realitivize() relativize constructs a relative path from
        // one Path object to another. In the example below it shows relativize is asking
        // "What is the path to get from path1 to .relativise(Path2).
        // i.e. go back a level in the directory, then go to path 2 therefore ../ means back, and then the file itself is printed.
        Path path1R = Paths.get("Fear.txt");
        Path path2R = Paths.get("Wolf.txt");
        // this returns:  ../Wolf.txt     and      ../Fear.txt
        System.out.println("relativize path: " + path1R.relativize(path2R));
        System.out.println("realtivize path2R to Path1R: " + path2R.relativize(path1R));

        Path path3R = Paths.get("have/no/Fear.txt");
        Path path4R = Paths.get("Wolf.txt");
        // this prints out ../have/no/Fear.txt
        System.out.println("Path4R to 3R: " + path4R.relativize(path3R));
        // this prints out ../../../Wolf.txt
        System.out.println("path3R to 4R: " + path3R.relativize(path4R));


        // When the path are absolute paths then it gets the absolute path from path1, to
        // .relativize(path2). e.g.
        Path path1A = Paths.get("/have/no/Fear.txt");
        Path path2A = Paths.get("/have/no/mind/Wolf.txt");
        // this prints out ../mind/Wolf.txt
        System.out.println("Path1A: " + path1A.relativize(path2A));
        // this prints out ../../Fear.txt
        System.out.println("path1A to 2A: " + path2A.relativize(path1A));

        // Relativize requires that both paths are absolute or both path are relative
        // if it is one of each, then an exception will be thrown at runtime

        // resolve() - Essentially this concatenates path1.resolve(path2) together
        Path pathRez = Paths.get("have/no/Fear.txt");
        Path pathRez2 = Paths.get("have/no/mind/Wolf.txt");
        System.out.println(pathRez.resolve(pathRez2));

        // if both paths are aboslute, then path1.resolve(path2) returns path2
        Path pathRezz = Paths.get("/have/no/Fear.txt");
        Path pathRezz2 = Paths.get("/have/no/mind/Wolf.txt");
        System.out.println(pathRezz.resolve(pathRezz2));

        // normalize() - removes ../ and ./ from files when possible
        // if the paths are relative, it doesn't appear to work
        Path path1N = Paths.get("/../../Fear.txt");
        Path path2N = Paths.get("/../mind/Wolf.txt");
        // this prints out ../mind/Wolf.txt
        System.out.println("Normalized path1N: " + path1N.normalize());
        // this prints out ../../Fear.txt
        System.out.println("Normalized path2N: " + path2N.normalize());

        // toRealPath() - check a file exists with this
        // this will throw an exception of the path doesn't exist
        // System.out.println("Does path exist: " + path1N.toRealPath());
        Path realPath = Paths.get("/users/dmt/Documents/JavaOCP/IOdemo.txt");
        System.out.println(realPath.toRealPath());
        // this can also be written as
        boolean exists = Files.exists(realPath);
        System.out.println("does it exist: " + exists);

    }


}
