package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

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
    
    
	
	public void printHotelList() {
		
		Hashtable<Hotel, ArrayList<Attendant>> hotel = new Hashtable();
		
		for (RegistrationForm r : registrationForms) {
			if ( r.getHotel() != null) {
				ArrayList<Attendant> list = hotel.get(r.getHotel());
				if (list == null) {
					list = new ArrayList<>();
					hotel.put(r.getHotel(), list);
				}
			
				list.add(r.getAttendant());
			}
		}

		System.out.println("Hotel information:");
		
		Enumeration<Hotel> keys = hotel.keys();
		while(keys.hasMoreElements()) {
			Hotel h = keys.nextElement();
			ArrayList<Attendant> list = hotel.get(h);
			System.out.println(h.getName());
			for (Attendant a : list) {
				
				System.out.println(a); //opdater med Attendant tekst som skal sendes til hotel
			}
		}
		
	}
	
	
	public void printConferenceList() {
		
		for(RegistrationForm a : registrationForms) {
			System.out.println("----------------------------------------");
			System.out.println("Navn: " + a.getAttendant().getName());
			System.out.println("Adresse: " + a.getAttendant().getAdress());
			System.out.println("Telefon: " + a.getAttendant().getTelephone());
			System.out.println("Har ledsager: " + a.getAttendant().hasAttendant());
			
			if(a.getAttendant().hasattendant) {
				
			}
			
			
			System.out.println("----------------------------------------");
			
		}
		
	}
    
}
