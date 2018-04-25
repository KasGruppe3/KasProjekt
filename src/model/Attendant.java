package model;

public class Attendant extends Person {
    private String address;
    private String tlfNumber;
    private String company;
    private Companion companion;
    private boolean hasCompanion;
    private boolean hasCompany;
    
    
    
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
    private void createCompanion(String name) {
		Companion companion = new Companion(name, this);
	}
    
}
