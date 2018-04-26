package application;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import storage.Storage;

public class Service {

	
	//Conference service
	//--------------------------------------------------------------------------------------------------------------------------------------------
	
	public static Conference createConference(String name, String location, LocalDate date, int timeSpan, double price) {
		Conference c = new Conference(name, location, date, timeSpan, price);
		Storage.addConference(c);
		return c;
	}
	
	public static void removeConference(Conference conference) {
		Storage.removeConference(conference);
	}
	
	public static ArrayList<Conference> getConferences(){
		return Storage.getConferences();
	}
	
	public void printHotelList(Conference c) {
		
		Hashtable<Hotel, ArrayList<Attendant>> hotel = new Hashtable<Hotel, ArrayList<Attendant>>();
		
		for (RegistrationForm r : c.getRegistrationForm()) {
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
	
	
	public void printConferenceList(Conference c) {
		
		for(RegistrationForm a : c.getRegistrationForm()) {
			System.out.println("----------------------------------------");
			System.out.println("Navn: " + a.getAttendant().getName());
			System.out.println("Adresse: " + a.getAttendant().getAddress());
			System.out.println("Telefon: " + a.getAttendant().getTlfNumber());
			System.out.println("Har ledsager: " + a.getAttendant().hasCompanion());
			
			if(a.getAttendant().hasCompanion()) {
				System.out.println(a.getAttendant().getCompanion().getName());
			}			
			System.out.println("----------------------------------------");
			
		}
		
	}
    
	
	public void printListFieldTrip(Conference co) {
		for (FieldTrip f : co.getFieldTrips()) {
			System.out.println("---------------------------------------------");
			System.out.println("Udflugts beskrivelse: " + f.getDescription() + ", dato: " + f.getDate() + ", middag inklusiv: " + f.isHasLunch() + ", pris: " + f.getPrice());
			for (Companion c : f.getCompanions()) {
				System.out.println("navn: " + c.getName());
			}
			System.out.println("---------------------------------------------");
		}
	}
	
	
	//Hotel
	//--------------------------------------------------------------------------------------------------------------------------------------------
	
	public static Hotel createHotel(String name, String address, double priceSingle, double priceDouble) {
		Hotel h = new Hotel(name, address, priceSingle, priceDouble);
		Storage.addHotel(h);
		return h;
	}
	
	public ArrayList<Extra> getExtra(Hotel hotel) {
		return hotel.getExtra();
	}
	
	public void removeHotel(Hotel hotel) {
		Storage.removeHotel(hotel);
	}
	
	public ArrayList<Hotel> getHotel() {
		return Storage.getHotels();
	}
	
	//Attendant
	//--------------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	//FieldTrip
	//--------------------------------------------------------------------------------------------------------------------------------------------
	
	//RegistrationForm
	//--------------------------------------------------------------------------------------------------------------------------------------------
	
	//Calculations
	//--------------------------------------------------------------------------------------------------------------------------------------------

}
