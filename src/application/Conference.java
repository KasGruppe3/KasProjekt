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
     * This will also remove the companion from fieldtrips
     *
     * @param registrationForm
     *            the registration to remove
     */
    public void removeRegistrationForm(RegistrationForm registrationForm) {
        // Fjern ledsageren fra turene
        Companion companion = registrationForm.getCompanion();
        for (FieldTrip fieldTrip : fieldTrips) {
            fieldTrip.removeCompanion(companion);
        }

        // Fjern registreringen
        this.registrationForms.remove(registrationForm);
    }

    /**
     * Adds a fieldtrip to the conference that attendants companions can
     * participate in
     * 
     * @param meeting
     *            Time The time the fieldtrip will start
     * @param date
     *            The date the fieldtrip takes place
     * @param description
     *            Additional information regarding the fieldtrip
     * @param price
     *            The cost of participation
     * @param hasLunch
     *            True if lunch is included in the price
     * @return The fieldtrip instance
     */
    public FieldTrip addFieldTrip(LocalTime meetingTime, LocalDate date, String description, double price,
            boolean hasLunch) {
        FieldTrip f = new FieldTrip(date, meetingTime, description, price, hasLunch);
        fieldTrips.add(f);
        return f;
    }

    public void removeFieldTrip(FieldTrip fieldTrip) {
        fieldTrips.remove(fieldTrip);
    }

}
