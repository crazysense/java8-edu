package examples.section06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

import static examples.section06.util.Utils.show;

public class StreamTransformationDemo {
    public static void main(String[] args) {
        // 1. Distinct
        Stream<String> uniqueWords = Stream.of("merrily", "merrily", "merrily", "gently")
                .distinct();
        show("uniqueWords", uniqueWords);

        // 2. Sorted
        Stream<String> sorted =  Stream.of("Z", "W", "A", "C", "B").sorted();
        show("sorted", sorted);

        // 3. Distinct and sorted
        Stream<String> distinctSorted =  Stream.of("Z", "B", "A", "C", "B", "C", "Y", "N").distinct().sorted();
        show("distinctSorted", distinctSorted);

        // 4. Longest First
        Stream<String> longestFirst =  Stream.of("A", "AA", "AAA", "AAAA").sorted(Comparator.comparing(String::length).reversed());
        show("longestFirst", longestFirst);

        // 5. Stream to array
        Object[] powers = Stream.iterate(1.0, p -> p * 2).limit(20).toArray();
        System.out.println("Stream to array : " + Arrays.toString(powers));
    }
}
