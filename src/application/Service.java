package application;
import java.time.LocalDate;
import java.util.ArrayList;

import storage.Storage;

public class Service {

	
	//Conference service     //ikke f�rdiggjort
	//--------------------------------------------------------------------------------------------------------------------------------------------
	
	public static Conference createConference(String name, String location, LocalDate date, int timeSpan, double price) {
		Conference c = new Conference(name, location, date, timeSpan, price);
		Storage.addConference(c);
		return c;
	}
	
	public static void removeConference(Conference conference) {
		Storage.removeConference(conference);
	}
	
	public static void updateConference(Conference conference, String name, String location, LocalDate date, int timeSpan, double price) {
		conference.setName(name);
		conference.setLocation(location);
		conference.setDate(date);
		conference.setTimeSpan(timeSpan);
		conference.setPrice(price);
	}
	
	public static ArrayList<Conference> getConferences(){
		return Storage.getConferences();
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------------------
	
}
