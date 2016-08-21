package models.xml;

import org.simpleframework.xml.*;

@Root(name="web-address")
public class WebAddress {

    @Element
    private int id;

    @Element
    private String location;

    @Element
    private String url;

    public WebAddress(int id, String location, String url) {
        this.id       = id;
        this.location = location;
        this.url      = url;
    }

    public int getId() {
        return this.id;
    }

    public String getLocation() {
        return this.location;
    }

    public String getUrl() {
        return this.url;
    }
}
