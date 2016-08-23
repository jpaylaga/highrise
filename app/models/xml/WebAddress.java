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
        this.setId(id);
        this.setLocation(location);
        this.setUrl(url);
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

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}
