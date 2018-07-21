package ch8IO;

public class DeserializationDemo {
    // When deseializing an object, the constructor of the serialized class is not called.
    // instead Java calls the first no-arg constructor for the first nonserializable parent class,
    // Also static variables or default initializations are ignored.

    // anything marked with Transient will not be stored when serialized
    transient int unsaved = 0;

    public static void main(String[] args){







    }

}
