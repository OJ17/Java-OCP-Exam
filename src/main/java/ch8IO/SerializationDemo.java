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
        List<AClassToSerialize> aClassList = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(dataFile)))) {
            while (true) {
                Object object = in.readObject();
                if (object instanceof AClassToSerialize)
                    aClassList.add((AClassToSerialize) object);
            }
        } catch (EOFException e) {

        }

        return aClassList;
    }

    public static void createAClassToSerializeFile(List<AClassToSerialize> aClassToSerializes, File dataFile)
            throws IOException {
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
        createAClassToSerializeFile(aClassToSerializeList,dataFile);
        System.out.println(aList(dataFile));

    }


}
