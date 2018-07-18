package ch5DatesStringsAndLocalization;

import javax.annotation.Resource;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class Internationalization {

    // Internationalization is often used by a combination of Locales
    // and properties files
    public static void main(String[] args) {
        Locale l1 = new Locale.Builder()
                .setLanguage("en")
                .setRegion("US")
                .build();

        Locale l2 = new Locale.Builder()
                .setRegion("US")
                .setLanguage("en")
                .build();

        // System.out.println(Locale.getDefault());
        // Locale locale = new Locale("fr");
        // Locale.setDefault(locale);
        // System.out.println(Locale.getDefault());

        Locale us = new Locale("en", "US");
        Locale france = new Locale("fr", "FR");


        printProperties(us);
        System.out.println();
        printProperties(france);

        ResourceBundle rbx = ResourceBundle.getBundle("Zoo", us);
        Set<String> keys = rbx.keySet();
        System.out.println();
        keys.stream().map(k -> k + " " + rbx.getString(k))
                .forEach(System.out::println);


        // working with a properties file
        Properties props = new Properties();
        rbx.keySet().stream().forEach(k -> props.put(k, rbx.getString(k)));
        System.out.println();
        System.out.println(props.getProperty("Not really a prop"));
        System.out.println(props.getProperty("not a real prop", "get this instead"));


        // Resource bundles
        // two main methods for exam
        // ResourceBundle.getBundle("Fear")
        // ResourceBundle.getBundle("Fear", locale)
        // first one uses default locale, second uses 2nd parameter


    }

    public static void printProperties(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("open"));
    }
}
