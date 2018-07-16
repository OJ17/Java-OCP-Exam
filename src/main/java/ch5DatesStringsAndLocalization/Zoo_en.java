package ch5DatesStringsAndLocalization;

import java.util.ListResourceBundle;

public class Zoo_en extends ListResourceBundle {

    // This is another way of implementing a resource bundle
    // it has the ability to use a value type that isn't a string
    // and you can create the values of a properties file at runtime
    protected Object[][] getContents(){
        return new Object[][] {
                {"hello","Hello"},
                {"open","The zoo is open"}
        };
    }

}
