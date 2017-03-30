package sec02.data;

public interface Identified {
	default int getId() {
		return Math.abs(hashCode());
	}
}