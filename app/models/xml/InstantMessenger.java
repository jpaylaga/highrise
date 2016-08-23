package models.xml;

import org.simpleframework.xml.*;

@Root(name="instant-messenger")
public class InstantMessenger {

    @Element(name="id")
    private int id;

    @Element
    private String location;

    @Element
    private String protocol;

    @Element
    private String address;

    public InstantMessenger(int id, String location, String protocol, String address) {
        this.setId(id);
        this.setLocation(location);
        this.setProtocol(protocol);
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

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }
}
