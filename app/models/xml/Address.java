package models.xml;

import org.simpleframework.xml.*;

@Root
public class Address {

    @Element
    private int id;

    @Element(required=false)
    private String city;

    @Element(required=false)
    private String country;

    @Element
    private String location;

    @Element(required=false)
    private String state;

    @Element(required=false)
    private String street;

    @Element(required=false)
    private int zip;

    public Address() {
        super();
    }

    public Address(int id, String location) {
        this.setId(id);
        this.setLocation(location);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return this.street;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getZip() {
        return this.zip;
    }
}
