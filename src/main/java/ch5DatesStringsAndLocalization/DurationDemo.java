package ch5DatesStringsAndLocalization;

import java.awt.*;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationDemo {
    // Duration is similar to Period, except that instead of Years, Months, and Days
    // it works with the time component: Hours, Minutes, Seconds, Millis, Nanos

    public static void main(String[] args) {
        Duration daily = Duration.ofDays(1);
        Duration hourly = Duration.ofHours(2);
        Duration minutes = Duration.ofMinutes(4);
        Duration seconds = Duration.ofSeconds(10);
        Duration millis = Duration.ofMillis(233);
        Duration nanos = Duration.ofNanos(339);

        // Duration does not have a constructor that takes multiple values

        // There is also another generic factory method. This takes
        // input as a value, and a ChronoUnit. ChronoUnit is an enum for time constants
        Duration day = Duration.of(1, ChronoUnit.DAYS);
        Duration hour = Duration.of(1, ChronoUnit.HOURS);
        Duration minute = Duration.of(1, ChronoUnit.MINUTES);
        Duration second = Duration.of(1, ChronoUnit.SECONDS);
        Duration milli = Duration.of(1, ChronoUnit.MILLIS);
        Duration nano = Duration.of(1, ChronoUnit.NANOS);


        // ChronoUnit work

        // Whilst covering this it is also worth nothing that there are
        // some extra constants as part of the chrono unit enum
        // these are the date side of things
        ChronoUnit centuries = ChronoUnit.CENTURIES;
        ChronoUnit millenia = ChronoUnit.MILLENNIA;
        ChronoUnit decades = ChronoUnit.DECADES;
        ChronoUnit years = ChronoUnit.YEARS;
        ChronoUnit infinity = ChronoUnit.FOREVER;
        ChronoUnit weeks = ChronoUnit.WEEKS;
        ChronoUnit ERA = ChronoUnit.ERAS;
        ChronoUnit hDAYS = ChronoUnit.HALF_DAYS;

        LocalTime lt = LocalTime.of(5, 30);
        LocalTime lt1 = LocalTime.of(1, 0);
        // the between method prints the whole value difference between param 1 and 2
        // it uses the first as the context and asks how many hours is 2 less than 1
        // in this example, two is four hours behind 1, so the result is -4
        System.out.println(ChronoUnit.HOURS.between(lt, lt1));

        // as usual, if the ChronoUnit is comparing a minute on a date, it will fail
        // because there is no minute component to a LocalDate


    }

}
