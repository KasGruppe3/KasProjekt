package application;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Conference {
    private String name;
    private String location;
    private LocalDate date;
    private int timeSpan;
    private double price;
    private ArrayList<FieldTrip> fieldTrips = new ArrayList<>();
    private ArrayList<RegistrationForm> registrationForms = new ArrayList<>();

    public Conference(String name, String location, LocalDate date, int timeSpan, double price) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.timeSpan = timeSpan;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTimeSpan() {
        return timeSpan;
    }

    public void setTimeSpan(int timeSpan) {
        this.timeSpan = timeSpan;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<FieldTrip> getFieldTrips() {
        return new ArrayList<>(fieldTrips);
    }

    public ArrayList<RegistrationForm> getRegistrationForms() {
        return new ArrayList<>(registrationForms);
    }

    /**
     * Create a registration of an attendant to a conference
     *
     * @param att
     *            The attendant to register
     * @param arrivalDate
     *            The date of the attendants arrival
     * @param leavingDate
     *            The date of the attendants departure
     * @param isSpeaker
     *            True if the attendant is a speaker
     * @param comment
     *            Special comment from the attendant to the conference
     * @param hotel
     *            The hotel, if any, the attendant will be staying at
     * @param extraChoices
     *            Chosen extra services from the hotel
     * @return The filled out registration form
     */
    public RegistrationForm addRegistrationForm(Attendant att, LocalDate arrivalDate, LocalDate leavingDate,
            boolean isSpeaker, String comment, Hotel hotel, ArrayList<Extra> extraChoices) {
        // Create the registration instance
        RegistrationForm registrationForm = new RegistrationForm(this, arrivalDate, leavingDate, isSpeaker, comment,
                att, hotel, extraChoices);

        // Save it in our list
        registrationForms.add(registrationForm);

        // Add it to the attendants list
        att.addRegistrationForm(registrationForm);

        // Return it
        return registrationForm;
    }

    /**
     * Remove a registration from the conference.
     *
     * @param registrationForm
     *            the registration to remove
     */
    public void removeRegistrationForm(RegistrationForm registrationForm) {
        registrationForms.remove(registrationForm);
    }

    /**
     * Removes a companion from all the conferences field trips
     */
    public void removeCompanion(Companion companion) {
        for (FieldTrip fieldTrip : fieldTrips) {
            fieldTrip.removeCompanion(companion);
        }
    }

    /**
     * Adds a fieldtrip to the conference that attendants companions can
     * participate in
     */
    public void addFieldTrip(FieldTrip ft) {
        if (!fieldTrips.contains(ft))
            fieldTrips.add(ft);
    }

    public void removeFieldTrip(FieldTrip fieldTrip) {
        fieldTrips.remove(fieldTrip);
    }

}
