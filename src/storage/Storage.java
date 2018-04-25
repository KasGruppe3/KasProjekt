package storage;

import java.util.ArrayList;

import application.Attendant;
import application.Companion;
import application.Hotel;
import application.FieldTrip;
import application.RegistrationForm;
import application.Conference;

public class Storage {
	private static ArrayList<Attendant> attendants = new ArrayList<>();
	private static ArrayList<Companion> companions = new ArrayList<>();
	private static ArrayList<Hotel> hotels = new ArrayList<>();
	private static ArrayList<FieldTrip> fieldTrips = new ArrayList<>();
	private static ArrayList<RegistrationForm> registrationForms = new ArrayList<>();
	private static ArrayList<Conference> conferences = new ArrayList<>();
	
	//------------------------------------------------------------------------------
	  
	public static ArrayList<Attendant> getAttendants() {
	    return new ArrayList<>(attendants);
	}

	public static void addAttendant(Attendant attendant) {
        attendants.add(attendant);
    }

	public static void removeAttendant(Attendant attendant) {
        attendants.remove(attendant);
    }
	
	//------------------------------------------------------------------------------
	
	public static ArrayList<Companion> getCompanions() {
	    return new ArrayList<>(companions);
	}

	public static void addCompanion(Companion companion) {
		companions.add(companion);
    }

	public static void removeCompanion(Companion companion) {
		companions.remove(companion);
    }
	
	//------------------------------------------------------------------------------
	
	public static ArrayList<Hotel> getHotels() {
	    return new ArrayList<>(hotels);
	}

	public static void addHotel(Hotel hotel) {
		hotels.add(hotel);
    }

	public static void removeHotel(Hotel hotel) {
		hotels.remove(hotel);
    }
	
	//------------------------------------------------------------------------------
	
	public static ArrayList<FieldTrip> getFieldTrips() {
	    return new ArrayList<>(fieldTrips);
	}

	public static void addFieldTrip(FieldTrip fieldTrip) {
		fieldTrips.add(fieldTrip);
    }

	public static void removeFieldTrip(FieldTrip fieldTrip) {
		fieldTrips.remove(fieldTrip);
    }
	
	//------------------------------------------------------------------------------
	
	public static ArrayList<RegistrationForm> getRegistrationForms() {
	    return new ArrayList<>(registrationForms);
	}

	public static void addRegistrationForm(RegistrationForm registrationForm) {
		registrationForms.add(registrationForm);
    }

	public static void removeRegistrationForm(RegistrationForm registrationForm) {
		registrationForms.remove(registrationForm);
    }
	
	//------------------------------------------------------------------------------
	
	public static ArrayList<Conference> getConferences() {
	    return new ArrayList<>(conferences);
	}

	public static void addConference(Conference conference) {
		conferences.add(conference);
    }

	public static void removeConference(Conference conference) {
		conferences.remove(conference);
    }
}
