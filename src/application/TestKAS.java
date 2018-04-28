package application;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestKAS {
    private Conference conference;
    private Hotel[] hotels;
    private FieldTrip[] fieldtrips;

    @Before
    public void setUp() throws Exception {
        // Opret konferencen
        conference = new Conference("Hav og himmel", "Odense Universitet", LocalDate.of(2018, 5, 18), 3, 1500);

        // Opret ture til ledsagere
        fieldtrips = new FieldTrip[3];
        fieldtrips[0] = Service.createFieldTrip(LocalDate.of(2018, 5, 18), LocalTime.of(10, 0), "Byrundtur, Odense",
                125, true);
        fieldtrips[1] = Service.createFieldTrip(LocalDate.of(2018, 5, 19), LocalTime.of(10, 0), "Egeskov", 75, false);
        fieldtrips[2] = Service.createFieldTrip(LocalDate.of(2018, 5, 20), LocalTime.of(10, 0), 
                "Trapholt Museum, Kolding", 200, true);

        conference.addFieldTrip(fieldtrips[0]);
        conference.addFieldTrip(fieldtrips[1]);
        conference.addFieldTrip(fieldtrips[2]);

        // Opret hotellerne
        hotels = new Hotel[3];
        hotels[0] = new Hotel("Den Hvide Svane", "", 1050, 1250);
        hotels[0].addExtra("WiFi", 50, "");

        hotels[1] = new Hotel("Hotel Phønix", "", 700, 800);
        hotels[1].addExtra("WiFi", 75, "");
        hotels[1].addExtra("Bad", 200, "");

        hotels[2] = new Hotel("Pension Tusindfryd", "", 500, 600);
        hotels[2].addExtra("Morgenmad", 100, "Tillæg til prisen");
    }

    @Test
    public void testFinnMadsen() {
        // Opret deltager
        Attendant att = new Attendant("Finn Madsen", "dk", "12233445", "Telia");

        // Opret registrering
        RegistrationForm reg = conference.addRegistrationForm(att, LocalDate.of(2018, 5, 18), LocalDate.of(2018, 5, 20),
                false, "", null, null);

        // Beregn og test pris
        double pris = Service.CalculateInvoice(reg);
        assertEquals(4500.0, pris, 0.01);
    }

    @Test
    public void testNielsPetersen() {
        // Opret deltager
        Attendant att = new Attendant("Niels Petersen", "dk", "12345678", "Telia");

        // Opret registrering
        Hotel hotel = hotels[0];
        RegistrationForm reg = conference.addRegistrationForm(att, LocalDate.of(2018, 5, 18), LocalDate.of(2018, 5, 20),
                false, "", hotel, null);

        // Beregn og test pris
        double pris = Service.CalculateInvoice(reg);
        assertEquals(6600, pris, 0.01);
    }

    @Test
    public void testPeterSommer() {
        // Opret deltager
        Attendant att = new Attendant("Peter Sommer", "dk", "12233445", "firma");

        // Find hotel info
        Hotel hotel = hotels[0];
        ArrayList<Extra> extras = new ArrayList<>();
        extras.add(hotel.getExtras().get(0)); // wifi

        // Opret registrering
        RegistrationForm reg = conference.addRegistrationForm(att, LocalDate.of(2018, 5, 18), LocalDate.of(2018, 5, 20),
                false, "", hotel, extras);

        // Tilføj ledsager og meld til udflugter
        Companion comp = reg.createCompanion("Mie Sommer");
        fieldtrips[1].addCompanion(comp); // egeskov
        fieldtrips[2].addCompanion(comp); // trapholt

        // Beregn og test pris
        double pris = Service.CalculateInvoice(reg);
        assertEquals(7375, pris, 0.01);
    }

    @Test
    public void testLoneJensen() {
        // Opret deltager
        Attendant att = new Attendant("Lone Jensen", "dk", "22334455", "Telia");

        // Find hotel info
        Hotel hotel = hotels[0];
        ArrayList<Extra> extras = new ArrayList<>();
        extras.add(hotel.getExtras().get(0)); // wifi

        // Opret registrering
        RegistrationForm reg = conference.addRegistrationForm(att, LocalDate.of(2018, 5, 18), LocalDate.of(2018, 5, 20),
                true, "", hotel, extras);

        // Opret ledsager og meld til udflugter
        Companion comp = reg.createCompanion("Jan Madsen");
        fieldtrips[0].addCompanion(comp); // byrundtur
        fieldtrips[1].addCompanion(comp); // egeskov

        // Beregn og test pris
        double pris = Service.CalculateInvoice(reg);
        assertEquals(2800, pris, 0.01);
    }
}
