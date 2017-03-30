package sec02.data;

public interface Person {
	String getName();

	default int getId() {
		return 0;
	}
}