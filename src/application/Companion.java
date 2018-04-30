package application;

public class Companion extends Person {
	private Attendant attendant;

	Companion(String name, Attendant attendant) {
		super(name);
		this.attendant = attendant;
	}

	public Attendant getAttendant() {
		return attendant;
	}
}
