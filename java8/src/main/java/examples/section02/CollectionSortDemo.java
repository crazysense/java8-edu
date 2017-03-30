package examples.section02;

import examples.section02.data.Person;
import examples.section02.data.Persons;

import java.util.*;

import static java.util.Comparator.*;

public class CollectionSortDemo {
	public static void main(String[] args) {
		List<Person> actors = new ArrayList<>();
		Persons.initialize(actors);

		// 1. Default
		System.out.println("\n1. <<Default>>");
		actors.forEach(System.out::println);

		// 2. MyPersonComparator (FirstName)
		Collections.sort(actors, new MyPersonComparator());

		System.out.println("\n2. <<Sort by MyPersonComparator class (first name natural order)>>");
		actors.forEach(System.out::println);

		// 3. Anonymous Class (Gender)
		Collections.sort(actors, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getGender().compareTo(o2.getGender());
            }
        });

        System.out.println("\n3. <<Sort by anonymous class (gender)>>");
        actors.forEach(System.out::println);

        // 4. Lambda expression (LastName)
        Collections.sort(actors, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

        System.out.println("\n4. <<Sort by lambda expression (last name natural order)>>");
        actors.forEach(System.out::println);

        // 5. Comparator.comparing method (LastName Reverse)
        Collections.sort(actors, comparing(Person::getLastName).reversed());

        System.out.println("\n5. <<Sort by Comparator.comparing (last name reversed order)>>");
        actors.forEach(System.out::println);

        // 6.
        System.out.println("\n5. <<Sort by Comparator.comparing (null last middle name natural order)>>");
        Collections.sort(actors, comparing(Person::getMiddleName, nullsLast(naturalOrder())));
        actors.forEach(System.out::println);
	}
}

class MyPersonComparator implements Comparator<Person> {
	@Override
	public int compare(Person o1, Person o2) {
		return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
	}
}
