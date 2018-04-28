package application;

import java.time.LocalDate;
import java.util.ArrayList;

public class RegistrationForm {
    private LocalDate arrivalDate;
    private LocalDate leavingDate;
    private boolean isSpeaker;
    private String comment;
    private Attendant attendant;
    private Hotel hotel;
    private ArrayList<Extra> extraChoices;
    private Conference conference;
    private Companion companion;

    /**
     * @param conference
     *            The conference to attend
     * @param arrivalDate
     *            The date the attendant arrives at the conference
     * @param leavingDate
     *            The date the attendant leaves the conference
     * @param isSpeaker
     *            Is the attendant a speaker at the conference
     * @param comment
     *            Comments from the attendant to the conference
     * @param attendant
     *            The attendant attending the conference
     * @param hotel
     *            The hotel where the attendant is staying during the conference
     * @param extraChoices
     *            Selected hotel offers to include in the hotel booking
     */
    public RegistrationForm(Conference conference, LocalDate arrivalDate, LocalDate leavingDate, boolean isSpeaker,
            String comment, Attendant attendant, Hotel hotel, ArrayList<Extra> extraChoices) {
        this.arrivalDate = arrivalDate;
        this.leavingDate = leavingDate;
        this.isSpeaker = isSpeaker;
        this.comment = comment;
        this.attendant = attendant;
        this.hotel = hotel;
        this.extraChoices = extraChoices;
        this.conference = conference;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(LocalDate leavingDate) {
        this.leavingDate = leavingDate;
    }

    public boolean isSpeaker() {
        return isSpeaker;
    }

    public void setSpeaker(boolean isSpeaker) {
        this.isSpeaker = isSpeaker;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Attendant getAttendant() {
        return attendant;
    }

    public void setAttendant(Attendant attendant) {
        this.attendant = attendant;
    }

    public Hotel getHotel() {
        return hotel;
    }

    /**
     * Sets the hotel.
     * Note: Changing the hotel will reset the extra hotel choices.
     */
    public void setHotel(Hotel hotel) {
        if (this.hotel != hotel) {
            this.hotel = hotel;
            extraChoices = null;
        }
    }

    public ArrayList<Extra> getExtraChoices() {
        if (extraChoices == null) {
            return new ArrayList<Extra>();
        } else {
            return extraChoices;
        }
    }

    public void setExtraChoices(ArrayList<Extra> extraChoices) {
        this.extraChoices = extraChoices;
    }

    public Conference getConference() {
        return conference;
    }

    public Companion getCompanion() {
        return companion;
    }

    public boolean hasCompanion() {
        if (companion != null) {
            return true;
        }
        return false;
    }

    /**
     * Creates a companion for the attendant of the conference. If a companion
     * already exists, it will be removed from any fieldtrips they would have
     * attended.
     *
     * @param name
     *            The name of the companion
     * @return The created companion instance
     */
    public Companion createCompanion(String name) {
        if (companion != null) {
            removeCompanion();
        }

        companion = new Companion(name, getAttendant());
        return companion;
    }

    /**
     * Removes a companion from the registration. Will also remove it from all
     * fieldtrips.
     */
    public void removeCompanion() {
        if (companion != null) {
            // Fjern ledsageren fra alle turene
            ArrayList<FieldTrip> trips = conference.getFieldTrips();
            for (FieldTrip trip : trips) {
                trip.removeCompanion(companion);
            }

            companion = null;
        }
    }
}
