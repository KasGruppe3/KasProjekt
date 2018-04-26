package application;

import java.time.Period;
import java.util.ArrayList;

public class PaymentInformation {
    private RegistrationForm registrationForm;

    /**
     * @param registrationForm
     *            The registration form to calculate billing information from
     */
    public PaymentInformation(RegistrationForm registrationForm) {
        this.registrationForm = registrationForm;
    }

    /**
     * Returns the registration form associated with this payment information
     *
     * @return The associated registration form
     */
    public RegistrationForm getRegistrationForm() {
        return registrationForm;
    }

    /**
     * Calculates the total price for the stay at the conference and hotel
     *
     * @return total cost of the conference and hotel
     */
    public double calculateInvoicePrice() {
        return calculateConferencePrice() + calculateHotelPrice();
    }

    /**
     * Calculates the price of the hotel stay
     *
     * @return price of the hotel
     */
    public double calculateHotelPrice() {
        Hotel hotel = registrationForm.getHotel();
        if (hotel == null) {
            return 0.0;
        }

        // Get the number of days at the hotel.
        int days = getHotelStayDuration();

        // Calculate the price of single/double room
        double price = 0.0;
        if (registrationForm.hasCompanion()) {
            price += hotel.getPriceDouble() * days;
        } else {
            price += hotel.getPriceSingle() * days;
        }

        // Calculate the price of extras
        ArrayList<Extra> extras = registrationForm.getExtraChoices();
        if (extras != null) {
            for (Extra e : extras) {
                price += e.getPrice() * days;
            }
        }

        return price;
    }

    /**
     * Calculates the price of the conference and the fieldtrips the
     * attendants companion participates in.
     *
     * @return The cost of the conference
     */
    public double calculateConferencePrice() {
        Conference conference = registrationForm.getConference();
        Companion companion = registrationForm.getCompanion();

        // Calculate the price of the fieldtrips
        double totalPrice = 0.0;
        for (FieldTrip f : conference.getFieldTrips()) {
            if (f.getCompanions().contains(companion)) {
                totalPrice += f.getPrice();
            }
        }

        // Speakers don't pay to attend
        if (!registrationForm.isSpeaker()) {
            totalPrice += conference.getPrice() * getConferenceDuration();
        }

        return totalPrice;
    }

    // Returns the duration of the attendants stay in days at the conference
    // (all included)
    private int getConferenceDuration() {
        Period period = Period.between(registrationForm.getArrivalDate(), registrationForm.getLeavingDate());
        int days = 1 + period.getDays();
        return days;
    }

    // Returns the duration of the attendants stay in days at the hotel (all
    // included)
    private int getHotelStayDuration() {
        Period period = Period.between(registrationForm.getArrivalDate(), registrationForm.getLeavingDate());
        int days = period.getDays();
        return days;
    }
}
