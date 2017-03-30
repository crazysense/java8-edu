package sec08;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class DateAdjustersDemo {
    public static void main(String[] args) {

        // Find first Tuesday
        LocalDate firstTuesday = LocalDate.of(2017, 3, 1)
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
        System.out.println("First Tuesday : " + firstTuesday);

        // Find next workday
        LocalDate today = LocalDate.of(2017, 3, 31);
        TemporalAdjuster NEXT_WORKDAY = t -> {
            LocalDate result = (LocalDate) t;
            do {
                result = result.plusDays(1);
                // DayOfWeek : MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(7)
            } while (result.getDayOfWeek().getValue() > 5);
            return result;
        };

        LocalDate backToWork = today.with(NEXT_WORKDAY);
        System.out.println("Back to work : " + backToWork);
    }
}
