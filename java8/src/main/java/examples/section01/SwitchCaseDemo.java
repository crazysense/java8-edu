package examples.section01;

public class SwitchCaseDemo {
	enum WEEK {
		MON, TUE, WED, THU, FRI, SAT, SUN
	}

	public static void main(String[] args) {
		WEEK week = WEEK.SUN;
		switch (week) {
            case MON: case TUE: case WED: case THU: case FRI:
                System.out.println(week.name() + " is weekday.");
                break;
            case SAT: case SUN:
                System.out.println(week.name() + " is weekend.");
                break;
            default:
		}

		// Java 1.7 => Available String variable
        String weekStr = "FRI";
		switch (weekStr) {
            case "MON": case "TUE": case "WED": case "THU": case "FRI":
                System.out.println(weekStr + " is weekday.");
                break;
            case "SAT": case "SUN":
                System.out.println(weekStr + " is weekday.");
                break;
            default:
		}
	}
}
