package examples.section02;

import examples.section02.data.Person;
import examples.section02.data.Persons;

import java.util.ArrayList;
import java.util.List;

public class CollectionProcessDemo {
	public static void main(String[] args) {
		List<Person> actors = new ArrayList<>();
		Persons.initialize(actors);

		// 1. Process each actor
		// for loop
		System.out.println("\n1. <<for loop>>");
		for (int i = 0; i < actors.size(); i++) {
			process(actors.get(i));
		}

		// 2. Process each actor
		// foreach
		System.out.println("\n2. <<foreach>>");
		for (Person p : actors) {
			process(p);
		}

		// 2. Process each actor
		// lambda expression
		System.out.println("\n3. <<lambda>>");
		actors.forEach(p -> process(p));

		// 2-1. Process each actor
		// method reference
        System.out.println("\n4. <<lambda + method reference>>");
		actors.forEach(CollectionProcessDemo::process);
	}

	private static void process(Person p) {
		System.out.println("Processing ... " + p);
	}
}
