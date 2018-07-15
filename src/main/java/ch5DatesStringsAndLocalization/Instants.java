package ch5DatesStringsAndLocalization;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Instants {

    public static void main(String[] args) throws InterruptedException {

        // The instant class represents a slice of time, like a photograph
        // in this example, it counts the time it takes to run the below loop
        Instant now = Instant.now();
        for(int i = 0; i < 100; i++){
            Thread.sleep(1);
            int y = 100;
        }
        Instant later = Instant.now();
        Duration duration = Duration.between(now, later);
        System.out.println(duration.toNanos());

        Instant instant = Instant.ofEpochSecond(3432243424L);
        System.out.println(instant);
        Instant nextDay = instant.plus(1,ChronoUnit.DAYS);
        System.out.println(nextDay);
        Instant nextHour = instant.plus(1,ChronoUnit.HOURS);
        System.out.println(nextHour);

        // a quirk of the Instant class is that you cannot do maths on
        // year, month, and week field.
        // for example this throws an error:
       // Instant inst = instant.plus(1,ChronoUnit.YEARS);
        //System.out.println(inst);
    }
}
