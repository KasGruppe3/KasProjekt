package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

public class KASunittest {
    private Conference conference;
    private Hotel[] hotels;

    @Before
    public void setUp() throws Exception {
        // Opret konferencen
        conference = new Conference("Hav og himmel", "Odense Universitet", LocalDate.of(2018, 5, 18), 3, 1500);

        // Opret fieldtrips

        // Opret hotellerne
        hotels = new Hotel[3];
        hotels[0] = new Hotel("Den Hvide Svane", "", 1050, 1250);
        hotels[0].addExtra("WiFi", 50, "");

        hotels[1] = new Hotel("Hotel Phønix", "", 700, 800);
        hotels[1].addExtra("Bad", 200, "");
        hotels[1].addExtra("WiFi", 75, "");

        hotels[2] = new Hotel("Pension Tusindfryd", "", 500, 600);
        hotels[2].addExtra("Morgenmad", 100, "Tillæg til prisen");
    }

    @Test
    public void testFinnMadsen() {
        // Opret deltager
        Attendant att = new Attendant();

        // Opret registrering
        RegistrationForm reg = new RegistrationForm(conference, LocalDate.of(2018, 5, 18), LocalDate.of(2018, 5, 20),
                false, "", att, null, null);

        // Beregn og test pris
        PaymentInformation payment = new PaymentInformation(reg);
        Assert.assertEquals(4500, payment.calculateInvoicePrice(), 0.01);
    }

    @Test
    public void testNielsPetersen() {
        // Opret deltager
        Attendant att = new Attendant();

        // Opret registrering
        Hotel hotel = hotels[0];
        RegistrationForm reg = new RegistrationForm(conference, LocalDate.of(2018, 5, 18), LocalDate.of(2018, 5, 20),
                false, "", att, hotel, null);

        // Beregn og test pris
        PaymentInformation payment = new PaymentInformation(reg);
        Assert.assertEquals(6600, payment.calculateInvoicePrice(), 0.01);
    }
}
