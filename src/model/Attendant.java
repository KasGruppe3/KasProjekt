package model;

import java.util.ArrayList;

public class Attendant extends Person {
	private String address;
    private String tlfNumber;
    private String company;
    private Companion companion;
    ArrayList<RegistrationForm> registrationForms= new ArrayList<>();
    
    
    public Attendant(String name, String address, String tlfNumber, String company) {
		super(name);
		this.address = address;
		this.tlfNumber = tlfNumber;
		this.company = company;
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
    public void removeCompanion() {
		this.companion = null;
	}
    public boolean hasCompanion() {
    	return companion != null;
    }
    public boolean hasCompany() {
    	return company.isEmpty();
    }
    public Companion createCompanion(String name) {
		Companion companion = new Companion(name, this);
		companion.setAttendant(this);
		return companion;
	}
    public void addRegistrationForm() {
    	
    }
    
}
