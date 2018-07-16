package ch5DatesStringsAndLocalization;

import javax.annotation.Resource;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

public class Tax_en_US extends ListResourceBundle {

    protected Object[][] getContents() {
        return new Object[][] { {"tax",new UsTaxCode() }};
    }

    public static void main(String[] args){

        ResourceBundle rb = ResourceBundle.getBundle("ch5DatesStringsAndLocalization.Tax",Locale.US);
        System.out.println(rb.getObject("tax"));
    }
}
