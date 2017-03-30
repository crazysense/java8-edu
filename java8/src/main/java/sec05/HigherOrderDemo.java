package sec05;

import java.util.Arrays;
import java.util.Comparator;

public class HigherOrderDemo {
	public static Comparator<String> compareInDirecton(int direction) {
		return (x, y) -> direction * x.compareTo(y);
	}

	public static Comparator<String> reverse(Comparator<String> comp) {
		return (x, y) -> -comp.compare(x, y);
	}

	public static void main(String[] args) {
		String[] words = { "Mary", "had", "a", "little", "lamb" };

		// 1. Direction -1 : Reverse
		Arrays.sort(words, compareInDirecton(-1));

        System.out.println("\n1. <<Reverse>>");
        System.out.println(Arrays.toString(words));

		// 2. Comparator -1 : Reverse
		Arrays.sort(words, reverse(String::compareToIgnoreCase));

        System.out.println("\n2. <<Reverse : Ignore case>>");
        System.out.println(Arrays.toString(words));
	}
}
