package ch2DesignPatternsAndPrinciples;

// JavaBeans is an encapsulation standard in Java
// it is a naming convention for getters and setters, combined
// with the usual principles of encapsulation
public class Encapsulation {

    private String name = "Oliver";
    private String nameTwo = "Jones";
    private int age = 0;

    public Encapsulation(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
    // this check is part of the value of encapsulation
    // because it ensures that the data is in some way regulated
    // compared to just making name public
    public String setName(String name){
        if(name.length() > 3){
            this.name = name;
        }
        return name;
    }

    // Even encapsulation like this has benefits
    // because it enables developers to rewrite the logic for
    // accessing a field, without modifying external classes
    public String getNameTwo(){
        return nameTwo;
    }

    public void setNameTwo(String zwei){
        if(zwei != null) {
            this.nameTwo = zwei;
        }
    }

    public int setAge(){
        return age;
    }

}
