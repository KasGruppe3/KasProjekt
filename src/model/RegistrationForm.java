package model;

import java.time.LocalDate;
import java.util.ArrayList;
a
public class RegistrationForm {
    private LocalDate arrivalDate;
    private LocalDate leavingDate;
    private boolean isSpeaker;
    private String comment;
    private Attendant attendant;
    private Hotel hotel;
    private ArrayList<Extra> extraChoices;
    private Conference conference;

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
        if (hotel != this.hotel) {
            this.hotel = hotel;
            extraChoices.clear();
        }
    }

    public ArrayList<Extra> getExtraChoices() {
        return extraChoices;
    }

    public void setExtraChoices(ArrayList<Extra> extraChoices) {
        this.extraChoices = extraChoices;
    }

    public Conference getConference() {
        return conference;
    }
}
