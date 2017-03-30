package examples.section04;

import java.util.Arrays;
import java.util.Objects;

public class MethodReferenceDemo {
	public static void main(String[] args) {
	    String[] strings = { "Mary", "had", "a", "little", "lamb", null };

	    MethodReferenceDemo demo = new MethodReferenceDemo();

	    // 1. Instance Reference
        System.out.println("\n2. <<Print A>>");
        Arrays.stream(strings).forEach(demo::printA);

	    // 2. Static Reference
        System.out.println("\n2. <<Print B>>");
        Arrays.stream(strings).forEach(MethodReferenceDemo::printB);

        // 3. Mixed
        System.out.println("\n2. <<Print A except null>>");
        Arrays.stream(strings).filter(Objects::nonNull).forEach(demo::printA);
    }

	private void printA(String s) {
		System.out.println("Print A : " + s);
	}

	private static void printB(String s) {
		System.out.println("Print B : " + s);
	}
}
