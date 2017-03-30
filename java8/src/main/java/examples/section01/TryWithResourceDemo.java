package examples.section01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TryWithResourceDemo {
	public static void main(String[] args) {
		// Before Java 1.7
		BufferedReader br = null;
		try {
			br = Files.newBufferedReader(Paths.get("alice.txt"));
			System.out.println("#1 Line Count : " + lineCount(br));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// After Java 1.7
		try (BufferedReader br2 = Files.newBufferedReader(Paths.get("alice.txt"))) {
			System.out.println("#2 Line Count : " + lineCount(br2));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int lineCount(BufferedReader reader) throws IOException {
		int count = 0;
		while (reader.readLine() != null) {
			count++;
		}
		return count;
	}
}
