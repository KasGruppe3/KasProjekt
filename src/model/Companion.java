package model;

public class Companion extends Person {
	private Attendant attendant;
	
	public Companion(String navn, Attendant attendant) {
		super(navn);
		this.attendant = attendant;
		}
	
	public Attendant getAttendant() {
		return attendant;
	}
}
