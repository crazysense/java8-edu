package sec01;

import sec01.data.Person;
import sec01.data.Persons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import static sec01.data.Person.GENDER.*;

public class CollectionRemoveDemo {
	public static void main(String[] args) {
		List<Person> actors = new ArrayList<>();
		Persons.initialize(actors);

		// 1. Remove Male
		Iterator<Person> it = actors.iterator();
		while (it.hasNext()) {
			Person actor = it.next();
			if (actor.getGender().equals(MALE)) {
				it.remove();
			}
		}

        System.out.println("\n1. <<Remove Male>>");
		for (Person p : actors) {
			System.out.println(p);
		}

		// 2. Remove Female
		Persons.initialize(actors);
		actors.removeIf(new Predicate<Person>() {
			@Override
			public boolean test(Person person) {
				return person.getGender().equals(FEMALE);
			}
		});

        System.out.println("\n2. <<Remove Female>>");
		for (Person p : actors) {
			System.out.println(p);
		}

		// 3. Remove persons who without a middle name.
		Persons.initialize(actors);

		actors.removeIf(p -> !p.hasMiddleName());

        System.out.println("\n3. <<Remove persons who without a middle name>>");
		actors.forEach(p -> System.out.println(p));

		// 4. Remove persons who has a middle name.
		Persons.initialize(actors);

		actors.removeIf(Person::hasMiddleName);

        System.out.println("\n4. <<Remove persons who has a middle name>>");
		actors.forEach(System.out::println);
	}
}
