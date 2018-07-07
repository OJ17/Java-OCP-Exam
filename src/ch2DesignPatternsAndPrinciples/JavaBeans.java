package ch2DesignPatternsAndPrinciples;

// JavaBeans is an encapsulation standard in Java
// it is a naming convention for getters and setters, combined
// with the usual principles of encapsulation
public class JavaBeans {

    // private properties (capitalist)
    private String priField = "22";
    private String fieldTwo = "second";
    private int days = 0;
    boolean isFlagged;

    public JavaBeans(String priField) {
        this.priField = priField;
    }

    public String getPriField(){
        return priField;
    }

    // this check is part of the value of encapsulation
    // because it ensures that the data is in some way regulated
    // compared to just making priField public
    public String setPriField(String setPri){
        if(setPri.length() > 3){
            priField = setPri;
        }
        return priField;
    }

    // getters for non-boolean properites begin with get
    public String getFieldTwo(){
        return fieldTwo;
    }

    // the method name should have a prefix of set/get/is and be in pascal case
    // like this:
    public void setFieldTwo(String zwei){
        if(zwei != null) {
            this.fieldTwo = zwei;
        }
    }

    // getters for boolean can begin with is or get
    public boolean isFlagged(){
        return isFlagged;
    }

    // setter methods begin with set
    public int setDays(){
        return days;
    }


}
