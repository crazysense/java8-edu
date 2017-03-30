package examples.section02.data;

public class Person {
    public enum GENDER {
        MALE, FEMALE
    }

	private String firstName;
	private String middleName;
	private String lastName;
	private GENDER gender;

	public Person(String firstName, String lastName, GENDER gender) {
		this(firstName, null, lastName, gender);
	}

	public Person(String firstName, String middleName, String lastName, GENDER gender) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
	}
	
	public boolean hasMiddleName() {
		return !(middleName == null || middleName.isEmpty());
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public GENDER getGender() {
		return gender;
	}

	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	@Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
				(hasMiddleName() ? ", middleName='" + middleName + '\'' : "") +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                '}';
    }
}
