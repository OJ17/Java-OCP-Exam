package ch8IO;

import javax.xml.bind.SchemaOutputResolver;
import java.io.*;

public class BufferedStreams {
    // a buffered streams can speed up reading and writing to a file
    // many times over because it combines the bytes that can e read into larger
    // amounts. So rather than reading a single byte at a time to / from a file
    // you can buffer them and read n batches, i.e. 1024 bytes

    public static void main(String[] args) {

        // Reading contents of a file with a BufferedReader
        File file = new File("/users/dmt/Documents/JavaOCP/iostream.txt");
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            while (br.ready()) {
                System.out.println(br.readLine());
            }
        } catch (IOException e) {

        }

        // Writing contents to a file with a buffered reader
        File fBSW = new File("/users/dmt/Documents/JavaOCP/writeThis.txt");
        try (FileWriter fw = new FileWriter(fBSW);
             BufferedWriter br = new BufferedWriter(fw);) {
            System.out.println("Written to file");
            br.write("mind parallel deranger polymorphic, intangible");
            br.write(" like skies that freefall into the endless and resplendent riversr");
            br.write(" Behold the sun that generates the duality, in this");
            br.write(" night of the perfect dark");
        } catch (IOException e) {

        }

        // Old school file reader
        File fRR = new File("/users/dmt/Documents/JavaOCP/writeThis.txt");
        FileWriter fwr = null;
        BufferedWriter br = null;
        try {
            fwr = new FileWriter(fRR);
            br = new BufferedWriter(fwr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fwr != null) {
                    fwr.close();
                }
            } catch (IOException e) {

            }
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {

            }
        }

        // Streams and their base class must match
        // For example the below cause errors:
//      errors  try(
//        new BufferedInputStream(new FileReader("/user/dmt/ok"));
//        ){ } catch (IOException e){
//
//        }






    }

}
