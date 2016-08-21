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
        this.id       = id;
        this.location = location;
        this.address  = address;
    }

    public int getId() {
        return this.id;
    }

    public String getLocation() {
        return this.location;
    }

    public String getAddress() {
        return this.address;
    }
}
