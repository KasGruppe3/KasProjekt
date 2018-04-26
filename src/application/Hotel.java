package application;

import java.util.ArrayList;

public class Hotel {
    private String name;
    private String address;
    private double priceSingle;
    private double priceDouble;
    private ArrayList<Extra> extraOffers = new ArrayList<>();

    public Hotel(String name, String address, double priceSingle, double priceDouble) {
        this.name = name;
        this.address = address;
        this.priceSingle = priceSingle;
        this.priceDouble = priceDouble;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPriceSingle() {
        return priceSingle;
    }

    public void setPriceSingle(double priceSingle) {
        this.priceSingle = priceSingle;
    }

    public double getPriceDouble() {
        return priceDouble;
    }

    public void setPriceDouble(double priceDouble) {
        this.priceDouble = priceDouble;
    }

    public Extra addExtra(String name, double price, String description) {
        Extra extra = new Extra(name, price, description);
        extraOffers.add(extra);
        return extra;
    }

    public ArrayList<Extra> getExtras() {
        return new ArrayList<>(extraOffers);
    }

    public void removeExtra(Extra extra) {
        extraOffers.remove(extra);
    }

    @Override
    public String toString() {
        return "Hotel navn: " + this.name + ", adresse: " + this.address + ", single rum pris: " + this.priceSingle
                + ", double rum pris: " + this.priceDouble + ", antal extra offers: " + this.extraOffers.size();
    }
}
