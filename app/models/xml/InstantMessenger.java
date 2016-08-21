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
        this.id       = id;
        this.location = location;
        this.protocol = protocol;
        this.address  = address;
    }

    public int getId() {
        return this.id;
    }

    public String getLocation() {
        return this.location;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getAddress() {
        return this.address;
    }
}
