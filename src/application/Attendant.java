package application;

import java.util.ArrayList;

public class Attendant extends Person {
    private String address;
    private String tlfNumber;
    private String company;
    ArrayList<RegistrationForm> registrationForms = new ArrayList<>();

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

    public boolean hasCompany() {
        if (company != null) {
            return true;
        }
        return false;
    }

    public void addRegistrationForm(RegistrationForm registrationForm) {
        this.registrationForms.add(registrationForm);
    }

    public ArrayList<RegistrationForm> getRegistrationForms() {
        return new ArrayList<>(registrationForms);
    }
}
