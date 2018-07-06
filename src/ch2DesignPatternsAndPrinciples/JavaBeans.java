package ch2DesignPatternsAndPrinciples;

// JavaBeans is an encapsulation standard in Java
// it is a naming convention for getters and setters, combined
// with the usual principles of encapsulation
public class JavaBeans {

    private String priField = "22";
    private String fieldTwo = "second";
    private int days = 0;

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

    public String getFieldTwo(){
        return fieldTwo;
    }

    public void setFieldTwo(String zwei){
        if(zwei != null) {
            this.fieldTwo = zwei;
        }
    }

    public int setDays(){
        return days;
    }


}
