package main.java.interfaces;

public class AccessorsMutators {
    private boolean isMutable;
    private String thisIsTheBass;
    private int totalHoursSpent;

    public boolean getIsMutable(){
        return isMutable;
    }

    public boolean setIsMutable(boolean isM){
        this.isMutable = isM;
        return this.isMutable;
    }

    public String getThisIsTheBass(){
        return this.thisIsTheBass;
    }

    public String setThisIsTheBase(String baseString){
        this.thisIsTheBass = baseString;
        return this.thisIsTheBass;
    }

    public int getTotalHoursSpent(){
        return this.totalHoursSpent;
    }

    public int setTotalHoursSpent(int totalHoursSpent){
        if(totalHoursSpent < 1){
            return 0;
        }
        this.totalHoursSpent = totalHoursSpent;
        return this.totalHoursSpent;
    }

    // this class demonstrates the use of encapsulation principles
    // by writing the class like this access to mutate the variables is restricted
    // This means there can be validation to ensure data is as expected
    // i.e. not putting D.O.B as the future
}
