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
        this.setId(id);
        this.setLocation(location);
        this.setNumber(number);
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

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return this.number;
    }
}
