package sec08;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Locale;

public class FormattingDemo {
	public static void main(String[] args) {
		ZonedDateTime apollo11launch = ZonedDateTime.of(1969, 7, 16, 9, 32, 0, 0, ZoneId.of("America/New_York"));

		String formatted = DateTimeFormatter.ISO_DATE_TIME.format(apollo11launch);
		// 1969-07-16T09:32:00-05:00[America/New_York]
		System.out.println("\nApollo 1 launch ==> " + formatted);

		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
		formatted = formatter.format(apollo11launch);
		System.out.println("\nFormat to local time ==> " + formatted);

		ZonedDateTime localZoneTime = apollo11launch.withZoneSameInstant(ZoneId.systemDefault());
		formatted = formatter.format(localZoneTime);
        System.out.println("\nConvert to local timezone ==> " + formatted);

		formatter = DateTimeFormatter.ofPattern("E yyyy-MM-dd HH:mm");
		formatted = formatter.format(localZoneTime);
		System.out.println("\nChange format pattern ==> " + formatted);

        LocalDateTime epochTime = LocalDateTime.ofEpochSecond(1490254622, 0, localZoneTime.getOffset());
        System.out.println("\nSystem time offset ==> " + localZoneTime.getOffset());
        formatted = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").format(epochTime);

		System.out.println("\nUnix time convert to local timezone ==> " + formatted);

        System.out.print("\nDayOfWeek values to english locale ==> ");
        for (DayOfWeek w : DayOfWeek.values()) {
            System.out.print(w.getDisplayName(TextStyle.SHORT, Locale.ENGLISH) + " ");
        }
        System.out.println();
    }
}
