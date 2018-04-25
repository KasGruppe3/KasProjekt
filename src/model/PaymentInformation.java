package model;

import java.time.Period;

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
        // Calculate the number of days at the hotel.
        Period period = Period.between(registrationForm.getArrivalDate(), registrationForm.getLeavingDate());

        // Calculate the price of sing/double room
        if (null == registrationForm.getAttendant()) {
            return registrationForm.getHotel().getPriceDouble() * period.getDays();
        } else {
            return registrationForm.getHotel().getPriceSingle() * period.getDays();
        }
    }

    /**
     * Calculates the price of the conference and the fieldtrips the
     * attendants companion participates in.
     *
     * @return The cost of the conference
     */
    public double calculateConferencePrice() {
        Conference conference = registrationForm.getConference();
        Companion companion = registrationForm.getAttendant().getCompanion();

        // Calculate the price of the fieldtrips
        double fieldtripPrice = 0.0;
        for (FieldTrip f : conference.getFieldTrips()) {
            if (f.getCompanions().contains(companion)) {
                fieldtripPrice += f.getPrice();
            }

        }

        // Returns the price of the conference and fieldtrips
        return conference.getPrice() + fieldtripPrice;
    }

}
