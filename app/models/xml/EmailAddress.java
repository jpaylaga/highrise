package models.xml;

import org.simpleframework.xml.*;

@Root(name="email-address")
public class EmailAddress {

    @Element
    private String address;

    @Element
    private int id;

    @Element
    private String location;

    public EmailAddress(int id, String location, String address) {
        this.setId(id);
        this.setLocation(location);
        this.setAddress(address);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }
}
