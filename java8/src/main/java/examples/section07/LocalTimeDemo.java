package examples.section07;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class LocalTimeDemo {
	public static void main(String[] args) throws InterruptedException {
	    // Date
		LocalDate today = LocalDate.now();
		System.out.println("Today : " + today);

		LocalDate liberationDay = LocalDate.of(1945, 8, 15);
		System.out.println("National Liberation Day : " + liberationDay);

		LocalDate christmas = LocalDate.of(today.getYear(), Month.DECEMBER, 25);
		System.out.println("Until christmas : " + today.until(christmas));
		System.out.printf("Until christmas %d days.\n", today.until(christmas, ChronoUnit.DAYS));

		LocalDate thisLiberationDay = LocalDate.of(today.getYear(), Month.AUGUST, 15);
		System.out.printf("This year is the %dth anniversary of liberation.\n",
				liberationDay.until(thisLiberationDay, ChronoUnit.YEARS));

        // Time
        LocalTime now = LocalTime.now();
        LocalTime bedTime = LocalTime.of(23, 0);
        System.out.println("Now : " + now);
        System.out.println("Bed time : " + bedTime);

        LocalTime wakeup = bedTime.plusHours(8);
        System.out.println("Wakeup : " + wakeup);
    }
}
