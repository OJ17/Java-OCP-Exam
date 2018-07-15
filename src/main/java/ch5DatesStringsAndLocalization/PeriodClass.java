package ch5DatesStringsAndLocalization;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class PeriodClass {

    // Period is for Yearsm Months, and days like:
    // 2020/7/20

    public static void main(String[] args) {
        Period p = Period.ofMonths(1);
        LocalDate ldt = LocalDate.now().plus(p);

        // other common methods
        Period annual = Period.ofYears(1);
        Period month = Period.ofMonths(1);
        Period week = Period.ofWeeks(1);
        Period day = Period.ofDays(1);
        Period yearAndWeek = Period.of(1, 0, 3);

        // Methods cannot be chained when creating a period


        // Period can be printed to display the value much as you might expect
        // if a part of it is missing it will not display
        // Prints P21D when ran with sout
        Period pd = Period.ofWeeks(21);
        // Prints PM3
        System.out.println("PD: " + pd);
        Period pm = Period.ofMonths(3);
        System.out.println("PM: " + pm);
        // Prints P20M35D
        Period p20 = Period.of(0, 20, 35);
        System.out.println("p20: " + p20);
        // Prints P30Y20M35D
        Period p30 = Period.of(30, 20, 35);
        System.out.println("P30: " + p30);


    }
}
