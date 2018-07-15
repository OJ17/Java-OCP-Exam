package ch5DatesStringsAndLocalization;

import java.time.*;

public class DateAndTimeBasics {
    // in java.time.*;
    public static void main(String[] args){
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());
        System.out.println("_________________");
        // has calendar day i.e. (08/07/1992)
        LocalDate ld = LocalDate.now();
        // has a time element i.e. (11:34:07.343)
        // i.e. hours, minutes, seconds, millis?)
        LocalTime lt = LocalTime.now();
        // combination of ld and lt
        //LocalDateTime ldtCombination =
        LocalDateTime ldt = LocalDateTime.of(2017,12,
                02,6,0,0);
        ZonedDateTime nyZdt = ldt.atZone(ZoneId.of("GMT+3"));
        ZonedDateTime laZdt = ldt.atZone(ZoneId.of("GMT"));
        Duration d = Duration.between(nyZdt,laZdt);
        System.out.println(d);
        LocalDate ld1 = LocalDate.of(2015,Month.JANUARY,20);
        LocalDate ld2 = LocalDate.of(2015,1,20);
        Month month = Month.JANUARY;

        LocalTime time1 = LocalTime.of(7,20);
        LocalTime time2 = LocalTime.of(7,20,14);
        LocalTime time3 = LocalTime.of(7,20,14,13);

        LocalDateTime lDateT = LocalDateTime.of(ld1,time2);

        // Date and time manipulation
        LocalDate lDate = LocalDate.of(2019,Month.JANUARY,44);
        System.out.println(lDate);
        lDate = lDate.plusDays(2);
        System.out.println(lDate);
        lDate = lDate.plusWeeks(1);
        System.out.println(lDate);
        lDate = lDate.plusYears(2);
        System.out.println(lDate);

        LocalDate ldx = LocalDate.of(2020, Month.JANUARY,20);
        LocalTime lTime = LocalTime.of(7,20);
        LocalDateTime ldtx = LocalDateTime.of(ldx,lTime);
        System.out.println("DateTime  = " + ldx);
        ldtx = ldtx.minusDays(1);
        System.out.println(ldtx);
        ldtx = ldtx.minusHours(3);
        System.out.println(ldtx);
        ldtx = ldtx.minusSeconds(34);
        System.out.println(ldtx);

        // chaining methods is also possible
        LocalDateTime ldxt = LocalDateTime.now()
                .minusDays(1)
                .minusHours(3)
                .minusMinutes(4);
        // but LocalTime cannot use Days / Months / years
        // And localDate cannot use hours, minutes, seconds









    }
}
