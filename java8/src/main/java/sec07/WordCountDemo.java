package sec07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class WordCountDemo {
	public static void main(String[] args) throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("alice.txt")));
		List<String> words = Arrays.asList(contents.split("\\PL+"));

		// 1. Old version
		long count = 0;
		for (String w : words) {
			if (w.length() > 12) {
				count++;
			}
		}
		System.out.println("\n1. <<Increment count by for loop>>");
		System.out.println(count);

		// 2. Stream
		long count2 = words.stream().filter(w -> w.length() > 12).count();
		System.out.println("\n2. <<Using stream aggregation count function>>");
		System.out.println(count2);

		// 3. Average
        OptionalDouble od = words.stream()
                .filter(w -> w.length() > 12)
                .mapToInt(w -> w.length())
                .average();

        System.out.println("\n3. <<Using stream aggregation filter-map-average function>>");
        System.out.println(od.isPresent() ? od.getAsDouble() : "None");

        // 4. Logging
        System.out.println("\n4. <<Logging by peak function>>");
        OptionalInt oi = words.stream()
                .filter(w -> w.length() > 12)
                .skip(10)
                .mapToInt(w -> w.length())
                .limit(10)
                .sorted()
                .peek(System.out::println)
                .reduce((i1, i2) -> i1 < i2 ? i2 : i1);

        oi.ifPresent(i -> System.out.println("Max : " + i));

        // 5. FlatMap
        System.out.println("\n4. <<Character count by flatMap>>");
        Map<String, Integer> map = words.stream()
                .filter(w -> w.length() > 0)
                .limit(10)
                .map(arr -> arr.split(""))
                .flatMap(Arrays::stream)
                .peek(c -> System.out.print(c + " "))
                .collect(Collectors.toConcurrentMap(k -> k, v -> 1, (v1, v2) -> v1+=1));

        System.out.println("\n" + map);
    }
}
