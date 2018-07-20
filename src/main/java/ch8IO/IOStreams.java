package ch8IO;

import java.io.*;

public class IOStreams {
    // The difference between Streams and Readers/Writers
    // Streams are used for inputting all types of binary data

    // Reader and writer only work with char and String data

    // Some info on naming of Streams / writers / readers:
    // InputStream or OutputStream is for reading and writing binary data
    // A class with Reader or writer is used for character and String data
    // most inputclasses havecorresponding output class
    // low-level stream connects directly with the source of the data
    // high-level stream is built on top of another stream for wrapping
    // buffered in its name reads or writes groups of bytes instead of 1 by 1


    public static void main(String[] args) {
        // InputStream, OutputStream, Reader, and Writer
        // are all abstract classes and therefore cannot be instantiated directly

        // create a file on the file system
        File file = new File("/users/dmt/Documents/JavaOCP/iostream.txt");

        try (FileWriter fw = new FileWriter(file)) {
            fw.write("haitiThrowHex");
        } catch (IOException e) {
            assert false : "iOException";
        }

        try(FileReader fr = new FileReader("/users/dmt/Documents/JavaOCP/iostream.txt")){
            int x = 0;
            while(fr.ready()) {
                System.out.print((char) fr.read());
            }
            System.out.println("\n");
        } catch(IOException e){

        }

        try (FileInputStream fis = new FileInputStream("/users/dmt/Documents/JavaOCP/iostream.txt");) {

        } catch (IOException e) {
            assert false : "IOException";
        }

        // Reading and writing using a file output stream and file input stream
        try(FileInputStream fis = new FileInputStream("/users/dmt/Documents/JavaOCP/iostream.txt");
        BufferedInputStream is = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream("/users/dmt/Documents/JavaOCP/fileoutstr.txt");
        BufferedOutputStream bOS = new BufferedOutputStream(fos)){
            System.out.println("Mark supported: " + is.markSupported());
            if(is.markSupported()){
                // mark enables you to read as many bytes as you want up to the
                // limit value. e.g. below is 4 bytes
                is.mark(4);
                System.out.println("postmark: " + is.read());
                System.out.println("after read: " + is.read());
                // goes back to before the mark
                is.reset();
                System.out.println("aftermark: " + is.read());
            }
            is.read();
            // skip(x) skips over x bytes
            is.skip(2);

            int b;
            while((b = is.read()) != -1){
                bOS.write(b);
            }
        } catch (IOException e){

        }

        // ObjectInputStream and ObjectOutputStream
        // these two classes are commonly used for serialization

    }
}
