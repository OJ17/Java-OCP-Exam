package ch2DesignPatternsAndPrinciples.Polymorphism;

public class Spaceman extends Man implements LivesInSpace{

    int age;
    private int getAge(){
        return age;
    }
    // override annotation is good practice,
    // as it ensures that the method is overridden from the superclass
    @Override
    public boolean communicate() {
        return true;
    }

    public static void main(String[] args){

        // Here is an example of what polymorphism allows
        // you can see here the reference types are all different
        // but the declared types are the same
        // only one object is created, but it can be passed as an interface
        // it implements, or by the superclass it was created from
        Spaceman spaceman = new Spaceman();
        System.out.println(spaceman.getAge());

        LivesInSpace lis = spaceman;
        System.out.println(lis.communicate());

        Man man = spaceman;
        System.out.println(man.hasEyes());

        Object obj = spaceman;
        System.out.println(obj.toString());

        // only methods that are part of the reference type (Left hand side),
        // can be used despite the literal type of the object
        // so the below won't compile without casting
//        Object obj2 = spaceman;
//        obj2.getAge();


    }
}
