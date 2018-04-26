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

    public ArrayList<RegistrationForm> getRegistrationForm() {
        return new ArrayList<>(registrationForms);
    }

    public RegistrationForm addRegistrationForm(Attendant att, LocalDate arrivalDate, LocalDate leavingDate,
            boolean isSpeaker, String comment, Attendant attendant, Hotel hotel, ArrayList<Extra> extraChoices) {
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
