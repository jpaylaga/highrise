package models;

import java.util.*;
import org.simpleframework.xml.*;

@Root(name="people")
public class Contacts {

    @ElementList(inline=true, name="person")
    private List<Contact> contact;

    @Attribute
    private String type;

    public Contacts(List<Contact> contact, String type) {
        this.contact = contact;
        this.type = type;
    }

    public List<Contact> getContacts() {
        return this.contact;
    }

    public String getType() {
        return this.type;
    }
}
