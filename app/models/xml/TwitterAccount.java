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
        this.setId(id);
        this.setLocation(location);
        this.setUsername(username);
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}
