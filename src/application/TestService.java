package application;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestService {
    private Hotel[] hotels = new Hotel[3];
    private Conference[] conferences = new Conference[3];
    private FieldTrip[] fieldTrips = new FieldTrip[3];
    private Attendant[] attendants = new Attendant[3];
    private RegistrationForm[] registrations = new RegistrationForm[3];
    private Companion[] companions = new Companion[3];

    @Before
    /**
     * Creates all the instances needed for these tests
     */
    public void setUp() {
        hotels[0] = Service.createHotel("Hotel 1", "addresse 1", 1, 5);
        hotels[1] = Service.createHotel("Hotel 2", "addresse 2", 2, 6);
        hotels[2] = Service.createHotel("Hotel 3", "addresse 3", 3, 7);

        conferences[0] = Service.createConference("Konference 1", "Kbh", LocalDate.now(), 1, 100.0);
        conferences[1] = Service.createConference("Konference 2", "Aarhus", LocalDate.now(), 2, 200.0);
        conferences[2] = Service.createConference("Konference 3", "Odense", LocalDate.now(), 3, 300.0);

        fieldTrips[0] = Service.createFieldTrip(LocalDate.of(2018, 1, 1), LocalTime.of(10, 1), "Udflugt 1", 100, false);
        fieldTrips[1] = Service.createFieldTrip(LocalDate.of(2018, 1, 2), LocalTime.of(10, 2), "Udflugt 2", 200, false);
        fieldTrips[2] = Service.createFieldTrip(LocalDate.of(2018, 1, 3), LocalTime.of(10, 3), "Udflugt 3", 300, false);

        attendants[0] = Service.createAttendant("Deltager 1", "addresse 1", "1", "");
        attendants[1] = Service.createAttendant("Deltager 2", "addresse 2", "2", "");
        attendants[2] = Service.createAttendant("Deltager 3", "addresse 3", "3", "");

        registrations[0] = Service.createRegistrationForm(conferences[0], LocalDate.of(2018, 5, 1), LocalDate.of(2018, 5, 3), false, "comment", attendants[0], hotels[0], null);
        registrations[1] = Service.createRegistrationForm(conferences[0], LocalDate.of(2018, 5, 1), LocalDate.of(2018, 5, 3), false, "comment", attendants[1], hotels[1], null);
        registrations[2] = Service.createRegistrationForm(conferences[1], LocalDate.of(2018, 5, 1), LocalDate.of(2018, 5, 3), false, "comment", attendants[2], hotels[2], null);

        companions[0] = registrations[0].createCompanion("Ledsager 1");
        companions[1] = registrations[1].createCompanion("Ledsager 2");
        companions[2] = registrations[2].createCompanion("Ledsager 3");
    }

    @Test
    /**
     * Test the deletion of a conference.
     * This should also remove: registrations
     */
    public void testRemoveConference() {
        Service.removeConference(conferences[1]);

        // Check the service array for removal
        for (Conference conf : Service.getConferences()) {
            assertNotEquals("Konference findes stadig i Service klassen", conferences[1], conf);
        }

        // Check that the registrations are up to date
        ArrayList<RegistrationForm> regs = Service.getRegistrationForms();
        for (RegistrationForm reg : regs) {
            assertNotEquals("En registreringsform peger stadig på konferencen", conferences[1], reg.getConference());
        }
    }

    @Test
    /**
     * Test the removal of a fieldtrip.
     * This should also remove: links from conferences
     */
    public void testRemoveFieldTrip() {
        Service.removeFieldTrip(fieldTrips[1]);

        // Check the service array for removal
        assertFalse("Udflugten findes stadig i service klassen", Service.getFieldTrips().contains(fieldTrips[1]));

        // Check that no conference links to the removed fieldtrip
        for (Conference conf : Service.getConferences()) {
            assertFalse("En konference peger stadig på udflugten", conf.getFieldTrips().contains(fieldTrips[1]));
        }
    }

    @Test
    /**
     * Test the removal of a hotel.
     * postcondition: No registrations should link to the removed hotel
     */
    public void testRemoveHotel() {
        Service.removeHotel(hotels[1]);

        // Check the service array for removal
        assertFalse("Hotellet findes stadig i service klassen", Service.getHotels().contains(hotels[1]));

        // Check that the registrations are up to date
        ArrayList<RegistrationForm> regs = Service.getRegistrationForms();
        for (RegistrationForm reg : regs) {
            Hotel hotel = reg.getHotel();
            assertNotEquals("Hotel peges stadig på i en registreringsform", hotels[1], hotel);
        }
    }

    @Test
    /**
     * Test the removal of an attendant.
     * postcondition: Associated registrations are removed, companions removed from fieldtrips
     */
    public void testRemoveAttendant() {
        Service.removeAttendant(attendants[1]);

        // The attendants registration should not be in the system any more
        for (RegistrationForm rf : attendants[1].getRegistrationForms()) {
            assertFalse("Deltagerens registreringsform findes stadig i serviceklassen", Service.getRegistrationForms().contains(rf));
        }

        // Check all registrations to make sure none of them points to the attendant
        for (RegistrationForm rf : Service.getRegistrationForms()) {
            assertNotEquals("Deltageren peges stadig på af en regform", attendants[1], rf.getAttendant());
            assertNotEquals("Ledsageren peges stadig på af en regform", companions[1], rf.getCompanion());
        }

        // Check all fieldtrips for the companion
        for (FieldTrip ft : Service.getFieldTrips()) {
            assertFalse("Ledsageren peges stadig på af en udflugt", ft.getCompanions().contains(companions[1]));
        }
    }
}
