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
        fieldtrips[0] = conference.addFieldTrip(LocalTime.of(10, 0), LocalDate.of(2018, 5, 18), "Byrundtur, Odense",
                125, true);
        fieldtrips[1] = conference.addFieldTrip(LocalTime.of(10, 0), LocalDate.of(2018, 5, 19), "Egeskov", 75, false);
        fieldtrips[2] = conference.addFieldTrip(LocalTime.of(10, 0), LocalDate.of(2018, 5, 20),
                "Trapholt Museum, Kolding", 200, true);

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
        RegistrationForm reg = new RegistrationForm(conference, LocalDate.of(2018, 5, 18), LocalDate.of(2018, 5, 20),
                false, "", att, null, null);
        conference.addRegistrationForm(reg);

        // Beregn og test pris
        PaymentInformation payment = new PaymentInformation(reg);
        double pris = payment.calculateInvoicePrice();
        assertEquals(4500.0, pris, 0.01);
    }

    @Test
    public void testNielsPetersen() {
        // Opret deltager
        Attendant att = new Attendant("Niels Petersen", "dk", "12345678", "Telia");

        // Opret registrering
        Hotel hotel = hotels[0];
        RegistrationForm reg = new RegistrationForm(conference, LocalDate.of(2018, 5, 18), LocalDate.of(2018, 5, 20),
                false, "", att, hotel, null);
        conference.addRegistrationForm(reg);

        // Beregn og test pris
        PaymentInformation payment = new PaymentInformation(reg);
        double pris = payment.calculateInvoicePrice();
        assertEquals(6600, pris, 0.01);
    }

    @Test
    public void testPeterSommer() {
        // Opret deltager og ledsager
        Attendant att = new Attendant("Peter Sommer", "dk", "12233445", "firma");
        Companion comp = att.createCompanion("Mie Sommer");

        // Meld til udflugter
        fieldtrips[1].addCompanion(comp); // egeskov
        fieldtrips[2].addCompanion(comp); // trapholt

        // Find hotel info
        Hotel hotel = hotels[0];
        ArrayList<Extra> extras = new ArrayList<>();
        extras.add(hotel.getExtra().get(0)); // wifi

        // Opret registrering
        RegistrationForm reg = new RegistrationForm(conference, LocalDate.of(2018, 5, 18), LocalDate.of(2018, 5, 20),
                false, "", att, hotel, extras);
        conference.addRegistrationForm(reg);

        // Beregn og test pris
        PaymentInformation payment = new PaymentInformation(reg);
        double pris = payment.calculateInvoicePrice();
        assertEquals(7375, pris, 0.01);
    }

    @Test
    public void testLoneJensen() {
        // Opret deltager
        Attendant att = new Attendant("Lone Jensen", "dk", "22334455", "Telia");
        Companion comp = att.createCompanion("Jan Madsen");

        // Meld til udflugter
        fieldtrips[0].addCompanion(comp); // byrundtur
        fieldtrips[1].addCompanion(comp); // egeskov

        // Find hotel info
        Hotel hotel = hotels[0];
        ArrayList<Extra> extras = new ArrayList<>();
        extras.add(hotel.getExtra().get(0)); // wifi

        // Opret registrering
        RegistrationForm reg = new RegistrationForm(conference, LocalDate.of(2018, 5, 18), LocalDate.of(2018, 5, 20),
                true, "", att, hotel, extras);
        conference.addRegistrationForm(reg);

        // Beregn og test pris
        PaymentInformation payment = new PaymentInformation(reg);
        double pris = payment.calculateInvoicePrice();
        assertEquals(2800, pris, 0.01);
    }
}
