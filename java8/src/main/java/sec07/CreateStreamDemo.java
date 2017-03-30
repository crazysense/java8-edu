package sec07;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static sec07.util.Utils.show;

public class CreateStreamDemo {
	public static void main(String[] args) throws IOException {
		// 1. From arrays
		String[] str = new String[] { "Greeting", "Farewell", "Hello", "Good bye" };
		Stream<String> greetings = Stream.of(str);
		show("greetings", greetings);

		// 2. From strings
		Stream<String> countries = Stream.of("KOREA", "USA", "CHINA", "RUSIA", "JAPAN");
		show("countries", countries);

		// 3. Empty stream
		Stream<String> empty = Stream.empty();
		show("empty", empty);

		// 4. Generator
		Stream<String> echos = Stream.generate(() -> "Echo");
		show("echos", echos);

		// 5. Random generator
		Stream<Double> randoms = Stream.generate(Math::random);
		show("randoms", randoms);

		// 6. Integer
		Stream<BigInteger> integers = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE)).skip(10).limit(5);
		show("integers", integers);

		// 7. From another stream
        Stream<String> stream1 = Stream.of("Hello".split(""));
        Stream<String> stream2 = Stream.of("World".split(""));
        Stream combined = Stream.concat(stream1, stream2);
        show("combined", combined);

		// 7. From file
		try (Stream<String> lines = Files.lines(Paths.get("alice.txt"))) {
			show("lines", lines);
		}
	}
}
