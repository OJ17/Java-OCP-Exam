package ch8IO;

import java.io.Serializable;

// to make a class serializable requires using the Seralizable interface
public class AClassToSerialize implements Serializable {
    // it is good practice to use a serialVersionUID and increment when modifying the class
    // this UID is stored when seralizing the object, so provides a way to uniquely identify the class
    private static final long serialVersionUID = 1L;
    // transient means the value won't be included in the serialisation process
    private transient String name;
    private int age;
    private char type;

    public AClassToSerialize(String name, int age, char type){
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }

    public char getType() {
        return type;
    }

    public String toString() {
        return "AClassToSerialize [name]" + name + ", age=" + age + ", type=" + type + "]";
    }
}
