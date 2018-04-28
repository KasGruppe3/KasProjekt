package application;

import java.util.ArrayList;

/**
 * A person who can attend conferences
 *
 */
public class Attendant extends Person {
    private String address;
    private String tlfNumber;
    private String company;
    ArrayList<RegistrationForm> registrationForms = new ArrayList<>();

    /**
     * Creates a new attendant.
     * 
     * @param name
     *            Name of the attendant
     * @param address
     *            Address of the attendant
     * @param tlfNumber
     *            Phonenumber where the attendant can be reached
     * @param company
     *            Company the attendant works for
     */
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

    /**
     * @return Returns true if the attendant works for a company
     */
    public boolean hasCompany() {
        if (company != null) {
            return true;
        }
        return false;
    }

    /**
     * Adds a copy of the registrationform that was created on the Conference
     * class
     * 
     * @param registrationForm
     *            copy of the registration form
     */
    public void addRegistrationForm(RegistrationForm registrationForm) {
        this.registrationForms.add(registrationForm);
    }

    public ArrayList<RegistrationForm> getRegistrationForms() {
        return new ArrayList<>(registrationForms);
    }

    public void removeRegstrationForm(RegistrationForm registrationForm) {
        registrationForms.remove(registrationForm);
    }
}
