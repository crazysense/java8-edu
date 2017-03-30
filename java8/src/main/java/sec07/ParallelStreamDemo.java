package sec07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamDemo {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("alice.txt")));
        List<String> words = Arrays.asList(contents.split("\\PL+"));

        // 1. Character count
        // The order changes each time you run it.
        Map<String, Integer> map = words.parallelStream()
                .filter(w -> w.length() > 0)
                .limit(20)
                .map(arr -> arr.split(""))
                .flatMap(Arrays::stream)
                .peek(c -> System.out.print(c + " "))
                .collect(Collectors.toConcurrentMap(k -> k, v -> 1, (v1, v2) -> v1+=1));

        System.out.println("\n" + map);

        // 2. Average word length
        // Average is not important the ordering.
        String[] arrWords = words.toArray(new String[]{});
        double average = Stream.of(arrWords).parallel()
                .filter(w -> w.length() > 0)
                //.filter(w -> w.length() > 100)
                .mapToDouble(w -> w.length())
                .average()
                .orElse(0);

        System.out.println("\nAverage : " + average);
    }
}
