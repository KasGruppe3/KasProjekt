package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Attendant extends Person {
	private String address;
    private String tlfNumber;
    private String company;
    private Companion companion;
    private RegistrationForm registrationForm;
    ArrayList<RegistrationForm> registrationForms= new ArrayList<>();
    
    
    public Attendant(String name, String address, String tlfNumber, String company, Companion companion) {
		super(name);
		this.address = address;
		this.tlfNumber = tlfNumber;
		this.company = company;
		this.companion = companion;
	}
    
    public String getAddress() {
		return address;
	}
    
    public void setAddress(String address) {
		this.address = address;
	}
    
    public String getTlfNumber() {
		return tlfNumber;
	}
    
    public void setTlfNumber(String tlfNumber) {
		this.tlfNumber = tlfNumber;
	}
    
    public String getCompany() {
		return company;
	}
    
    public void setCompany(String company) {
		this.company = company;
	}
    
    public Companion getCompanion() {
		return companion;
	}
	    
    public boolean hasCompanion() {
    	if(companion != null) {
    		return true;
    	} return false;
    }
    
    public boolean hasCompany() {
    	if(company != null) {
    		return true;
    	} return false;
	}
	
    public void createCompanion(String name) {
		Companion companion = new Companion(name, this);
		companion.setAttendant(this);
		return companion;
	}
    
    public RegistrationForm addRegistrationForm(Conference conference, LocalDate arrivalDate, LocalDate leavingDate, boolean isSpeaker,
            String comment, Attendant attendant, Hotel hotel, ArrayList<Extra> extraChoices) {
    	RegistrationForm registrationForm = new RegistrationForm(conference, arrivalDate, leavingDate, isSpeaker, comment, this, hotel, extraChoices);
    	registrationForms.add(registrationForm);
    	return registrationForm;
    }
}    
