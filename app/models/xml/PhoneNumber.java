package models.xml;

import org.simpleframework.xml.*;

@Root(name="phone-number")
public class PhoneNumber {

    @Element
    private int id;

    @Element
    private String location;

    @Element
    private String number;

    public PhoneNumber(int id, String location, String number) {
        this.id       = id;
        this.location = location;
        this.number   = number;
    }

    public int getId() {
        return this.id;
    }

    public String getLocation() {
        return this.location;
    }

    public String getNumber() {
        return this.number;
    }
}
