package examples.section06;

import java.util.Optional;
import java.util.stream.Stream;

public class WordMatchDemo {
    public static void main(String[] args) {
        String[] startWithO = new String[] { "Original", "Old", "Out", "Only" };

		boolean aWordEndWithY = Stream.of(startWithO).anyMatch(s -> s.endsWith("y"));
        System.out.println("A word end with 'y' ? " + aWordEndWithY);

        boolean allWordStartWithO = Stream.of(startWithO).allMatch(s->s.startsWith("O"));
        System.out.println("All words start with 'O' ? " + allWordStartWithO);

        Optional<String> aWordStartWithO = Stream.of(startWithO)
                .filter(s -> s.startsWith("O"))
                .findAny();

        System.out.println("A word start with O : " + aWordStartWithO.orElse("(None)"));

        Optional<String> aWordStartWithQ = Stream.of(startWithO)
                .filter(s -> s.startsWith("Q"))
                .findFirst();

        System.out.println("A word start with Q : " + aWordStartWithQ.orElse("(None)"));
    }
}
