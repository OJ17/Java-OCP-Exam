package ch8IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationDemo {
    // mostly ObjectInputStream and ObjectOutputStream are used for serialization and
    // deserialization respectively

    // ObjectOutputStream class has a writeObject(Object) method. If the
    // Object passed in is not Serializable, an exception "NotSerializableException" will
    // be thrown

    public static List<AClassToSerialize> aList(File dataFile) throws IOException,
            ClassNotFoundException {
        // this method is for deserializing an object. It takes a data file
        // as a parameter, then it creates a list. Then it creates an ObjectInputStream
        // and reads each object from the .data file, and adds it to the list
        List<AClassToSerialize> aClassList = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(dataFile)))) {
            // the reason this is while(true) is that it is not possible to
            // to use an integer to determine when the end of the file is reached
            // instead a catch block(EOFException) is created which catches and terminates
            // when the end of the file is reached
            while (true) {
                Object object = in.readObject();
                // this instanceof check is to avoid ClassCastException at runtime
                if (object instanceof AClassToSerialize)
                    aClassList.add((AClassToSerialize) object);
            }
        } catch (EOFException e) {

        }

        return aClassList;
    }

    public static void createAClassToSerializeFile(List<AClassToSerialize> aClassToSerializes, File dataFile)
            throws IOException {
        // this code takes in the list of objects, and the file path
        // then it creates an ObjectOutputStream and writes it to the file
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(dataFile))
        )) {
            for (AClassToSerialize aClassToSerialize : aClassToSerializes) {
                out.writeObject(aClassToSerialize);
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Create array of objects to Serialize
        List<AClassToSerialize> aClassToSerializeList = new ArrayList<>();
        aClassToSerializeList.add(new AClassToSerialize("Fear wolf", 5, 'T'));
        aClassToSerializeList.add(new AClassToSerialize("Endless craft", 4, 'x'));

        // this file is written to the FileSystem
        File dataFile = new File("AClassToSerialize.data");
        // this method serializes the objects
        createAClassToSerializeFile(aClassToSerializeList,dataFile);
        // this method is deserializing the objects
        System.out.println(aList(dataFile));

        // deserializing a specific element
        List<AClassToSerialize> aCTSL = aList(dataFile);
        aCTSL.forEach(s -> System.out.println("name is: "+ s.getType()));



    }


}
