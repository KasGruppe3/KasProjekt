package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Attendant extends Person {
	private String address;
    private String tlfNumber;
    private String company;
    private Companion companion;
    private RegistrationForm registrationForm;
    private boolean hasCompanion;
    private boolean hasCompany;
    ArrayList<RegistrationForm> registrationForms= new ArrayList<>();
    
    
    public Attendant(String name, String address, String tlfNumber, String company, boolean hasCompanion, boolean hasCompany) {
		super(name);
		this.address = address;
		this.tlfNumber = tlfNumber;
		this.company = company;
		this.hasCompanion = hasCompanion;
		this.hasCompany = hasCompany;
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
    public void setCompanion(Companion companion) {
		this.companion = companion;
	}
    public boolean getHasCompanion() {
    	return hasCompanion;
    }
    public boolean getHasCompany() {
    	return hasCompany;
    }
    public void setHasCompanion(boolean hasCompanion) {
		this.hasCompanion = hasCompanion;
	}
    public void setHasCompany(boolean hasCompany) {
		this.hasCompany = hasCompany;
	}
    public void createCompanion(String name) {
		Companion companion = new Companion(name, this);
	}
    public RegistrationForm addRegistrationForm(Conference conference, LocalDate arrivalDate, LocalDate leavingDate, boolean isSpeaker,
            String comment, Attendant attendant, Hotel hotel, ArrayList<Extra> extraChoices) {
    	RegistrationForm registrationForm = new RegistrationForm(conference, arrivalDate, leavingDate, isSpeaker, comment, this, hotel, extraChoices);
    	registrationForms.add(registrationForm);
    	return registrationForm;
    }
    
}
