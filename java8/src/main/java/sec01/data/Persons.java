package sec01.data;

import java.util.Collection;

import static sec01.data.Person.GENDER.FEMALE;
import static sec01.data.Person.GENDER.MALE;

public class Persons {
	public static void initialize(final Collection<Person> list) {
		if (list == null) {
			throw new RuntimeException("parameter list must be not null.");
		}

		list.clear();
		list.add(new Person("Chloë", "Grace", "Moretz", FEMALE));
		list.add(new Person("Scarlett", "Johansson", FEMALE));
		list.add(new Person("Robert", "De", "Niro", MALE));
		list.add(new Person("Matt", "Damon", MALE));
		list.add(new Person("Brad", "Pitt", MALE));
		list.add(new Person("Jennifer", "Lawrence", FEMALE));
		list.add(new Person("Leonardo", "DiCaprio", MALE));
		list.add(new Person("Tom", "Cruise", MALE));
		list.add(new Person("Keira", "Knightley", FEMALE));
	}
}
