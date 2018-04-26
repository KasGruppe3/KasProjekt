package application;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class Conference {
    private String name;
    private String location;
    private LocalDate date;
    private int timeSpan;
    private double price;
    private ArrayList<FieldTrip> fieldTrips = new ArrayList<FieldTrip>();
    private ArrayList<RegistrationForm> registrationForms = new ArrayList<RegistrationForm>();
    
	
    public Conference(String name, String location, LocalDate date, int timeSpan, double price) {
		this.name = name;
		this.location = location;
		this.date = date;
		this.timeSpan = timeSpan;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getTimeSpan() {
		return timeSpan;
	}

	public void setTimeSpan(int timeSpan) {
		this.timeSpan = timeSpan;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public ArrayList<FieldTrip> getFieldTrips(){
		return  new ArrayList<FieldTrip>(fieldTrips);
	}
	
	public ArrayList<RegistrationForm> getRegistrationForm() {
		return new ArrayList<RegistrationForm>(registrationForms);
	}
	
	public void addRegistrationForm(RegistrationForm registrationForm) {
		this.registrationForms.add(registrationForm);
	}
	
	public void removeRegistrationForm(RegistrationForm registrationForm) {
		this.registrationForms.remove(registrationForm);
	}
	
	public FieldTrip addFieldTrip(LocalTime meetingTime, LocalDate date, String description, double price, boolean hasLunch) {
		
		FieldTrip f = new FieldTrip(date, meetingTime, description, price, hasLunch);
		
		fieldTrips.add(f);
		
		return f;
	}
	
	public void removeFieldTrip(FieldTrip fieldTrip) {
		fieldTrips.remove(fieldTrip);
	}
	
}
