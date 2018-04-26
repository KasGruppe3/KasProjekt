package application;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Describes a fieldtrip that is offered by a conference.
 *
 * @author Kenneth G.
 *
 */
public class FieldTrip {
    private LocalDate date;
    private LocalTime meetingTime;
    private String description;
    private double price;
    private boolean hasLunch;
    private ArrayList<Companion> companions;

    /**
     * @param date
     *            The date when the fieldtrip will take place
     * @param meetingTime
     *            The time of day the fieldtrip will start
     * @param description
     *            Describes the trip and other miscelaneous information
     * @param price
     *            The price of the fieldtrip
     * @param hasLunch
     *            True, if lunch is included in the price
     */
    public FieldTrip(LocalDate date, LocalTime meetingTime, String description, double price, boolean hasLunch) {
        this.date = date;
        this.meetingTime = meetingTime;
        this.description = description;
        this.price = price;
        this.hasLunch = hasLunch;
        this.companions = new ArrayList<>();
    }

    /**
     * Adds an attendants companion to the fieldtrip
     *
     * @param companion
     *            The companion to add to the fieldtrip
     */
    public void addCompanion(Companion companion) {
        if (!companions.contains(companion)) {
            companions.add(companion);
        }
    }

    /**
     * Removes a companion from a fieldtrip
     *
     * @param companion
     *            The companion to remove from the fieldtrip
     */
    public void removeCompanion(Companion companion) {
        companions.remove(companion);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(LocalTime meetingTime) {
        this.meetingTime = meetingTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isHasLunch() {
        return hasLunch;
    }

    public void setHasLunch(boolean hasLunch) {
        this.hasLunch = hasLunch;
    }

    public ArrayList<Companion> getCompanions() {
        return companions;
    }
}
