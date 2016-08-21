package models.xml;

import org.simpleframework.xml.*;

@Root(name="twitter-account")
public class TwitterAccount {

    @Element
    private int id;

    @Element
    private String location;

    @Element
    private String username;

    @Element
    private String url;

    public TwitterAccount(int id, String location, String username, String url) {
        this.id       = id;
        this.location = location;
        this.username = username;
        this.url      = url;
    }

    public int getId() {
        return this.id;
    }

    public String getLocation() {
        return this.location;
    }

    public String getUsername() {
        return this.username;
    }

    public String getUrl() {
        return this.url;
    }
}
