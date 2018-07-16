package ch5DatesStringsAndLocalization;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class FormattingLocales {
    public static void main(String[] args) throws ParseException {
        // the number format classes enable the user to format numbers
        // to be aligned with local conventions. Below are 3 different ways
        // of showing the same number in different countries
        int lostThoughtsPerYear = 4_500_000;
        int lostThoughtsPerMonth = lostThoughtsPerYear / 12;
        NumberFormat us = NumberFormat.getInstance(Locale.US);
        System.out.println(us.format(lostThoughtsPerMonth));
        NumberFormat g  = NumberFormat.getInstance(Locale.GERMANY);
        System.out.println(g.format(lostThoughtsPerMonth));
        NumberFormat ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
        System.out.println(ca.format(lostThoughtsPerMonth));

        // Formatting currency
        double price = 76;
        NumberFormat usofa = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(usofa.format(price));

        // parse method
        NumberFormat en = NumberFormat.getInstance(Locale.US);
        NumberFormat fr  = NumberFormat.getInstance(Locale.FRANCE);
        String s = "40.45";
        System.out.println();
        // the output of this depends on the country in the US
        // the . is for decimal places. In France it does not
        // and so is cut when reading from the french Locale
        System.out.println(en.parse(s));
        System.out.println(fr.parse(s));
        System.out.println();
        // Formatting dates and times
        // ISO is a standard for dates
        LocalDate ld = LocalDate.of(2020,Month.JANUARY,20);
        LocalTime time = LocalTime.of(11,12,34);
        LocalDateTime dateTime = LocalDateTime.of(ld,time);
        System.out.println(ld.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        System.out.println();
        DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(shortDateTime.format(dateTime));
        System.out.println();
        System.out.println("mediums");

        LocalDate ldate = LocalDate.of(2020,Month.JANUARY,20);
        LocalTime ltime = LocalTime.of(11,12,34);
        LocalDateTime ldatetime = LocalDateTime.of(ldate,ltime);
        DateTimeFormatter dtff = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(dtff.format(ldatetime));
        System.out.println();

        // You can also create your own pattern for formatting dates
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
        System.out.println(dateTime.format(f));
        

    }
}
