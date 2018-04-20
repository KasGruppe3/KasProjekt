package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Conference {
    private String name;
    private String location;
    private LocalDate date;
    private int timeSpan;
    private double price;
    private ArrayList<FieldTrip> fieldTrip = new ArrayList<FieldTrip>();
    private ArrayList<RegistrationForm> registrationForm = new ArrayList<RegistrationForm>();
    
	
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
    
    
	
	public void printListHotel() {
		
		for (RegistrationForm r : registrationForm) {
			if (r.get)
		}
		
	}
    
}
