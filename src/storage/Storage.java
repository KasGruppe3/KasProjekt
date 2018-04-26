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
	
	//Attendants
	//------------------------------------------------------------------------------
	 
	
	/**
	 * Gets an ArrayList of all attendants from storage
	 * @return ArrayList<Attendant>
	 */
	public static ArrayList<Attendant> getAttendants() {
	    return new ArrayList<>(attendants);
	}

	/*
	 * Adds an attendant to storage
	 */
	public static void addAttendant(Attendant attendant) {
        attendants.add(attendant);
    }

	/*
	 * Removes a specific attendant from storages
	 */
	public static void removeAttendant(Attendant attendant) {
        attendants.remove(attendant);
    }
	
	//Companions
	//------------------------------------------------------------------------------
	
	/**
	 * Gets an ArrayList of all companions from storage
	 * @return ArrayList<Companion>
	 */
	public static ArrayList<Companion> getCompanions() {
	    return new ArrayList<>(companions);
	}

	/*
	 * Adds a companion to storage
	 */
	public static void addCompanion(Companion companion) {
		companions.add(companion);
    }

	/*
	 * Removes a specific companion from storages
	 */
	public static void removeCompanion(Companion companion) {
		companions.remove(companion);
    }
	
	//Hotels
	//------------------------------------------------------------------------------
	
	/**
	 * Gets an ArrayList of all hotels from storage
	 * @return ArrayList<Hotels>
	 */
	public static ArrayList<Hotel> getHotels() {
	    return new ArrayList<>(hotels);
	}

	/*
	 * Adds a hotel to storage
	 */
	public static void addHotel(Hotel hotel) {
		hotels.add(hotel);
    }

	/*
	 * Removes a specific hotel from storages
	 */
	public static void removeHotel(Hotel hotel) {
		hotels.remove(hotel);
    }
	
	
	//FieldTrips
	//------------------------------------------------------------------------------
	
	/**
	 * Gets an ArrayList of all fieldTrips from storage
	 * @return ArrayList<FieldTrip>
	 */
	public static ArrayList<FieldTrip> getFieldTrips() {
	    return new ArrayList<>(fieldTrips);
	}

	/*
	 * Adds a fieldTrip to storage
	 */
	public static void addFieldTrip(FieldTrip fieldTrip) {
		fieldTrips.add(fieldTrip);
    }

	/*
	 * Removes a specific fieldtrip from storages
	 */
	public static void removeFieldTrip(FieldTrip fieldTrip) {
		fieldTrips.remove(fieldTrip);
    }
	
	
	//RegistrationForms
	//------------------------------------------------------------------------------
	
	/**
	 * Gets an ArrayList of all registrationForms from storage
	 * @return ArrayList<RegistrationForm>
	 */
	public static ArrayList<RegistrationForm> getRegistrationForms() {
	    return new ArrayList<>(registrationForms);
	}

	/*
	 * Adds a registrationForm to storage
	 */
	public static void addRegistrationForm(RegistrationForm registrationForm) {
		registrationForms.add(registrationForm);
    }

	/*
	 * Removes a specific registrationForm from storages
	 */
	public static void removeRegistrationForm(RegistrationForm registrationForm) {
		registrationForms.remove(registrationForm);
    }
	
	//Conferences
	//------------------------------------------------------------------------------
	
	/**
	 * Gets an ArrayList of all conferences from storage
	 * @return ArrayList<Conference>
	 */
	public static ArrayList<Conference> getConferences() {
	    return new ArrayList<>(conferences);
	}

	/*
	 * Adds a conference to storage
	 */
	public static void addConference(Conference conference) {
		conferences.add(conference);
    }

	/*
	 * Removes a specific conference from storages
	 */
	public static void removeConference(Conference conference) {
		conferences.remove(conference);
    }
}
