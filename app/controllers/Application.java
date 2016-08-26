package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import models.jpa.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void display() {
        List<Tag> tags = Tag.all().fetch();
        render(tags);
    }

    public static void loadContactsByTag(String tag) {

        String username = Play.configuration.getProperty("highrise.username");
        String apikey   = Play.configuration.getProperty("highrise.apikey");

        try {
            JsonableArrayList<Contact> contacts = ContactsFactory.createFromTag(tag, username, apikey);
            for (Contact contact : contacts) {
                if (!Contact.hasSame(contact)) {
                    contact.save();
                }
            }
            renderJSON(contacts.toJson("contacts"));
        } catch (Exception e) {
            renderJSON("{\"error\":\"" + e + "\"}");
        }
    }

    public static void loadContactsFromDatabase() {
        List<Contact> rawContacts = Contact.all().fetch();
        JsonableArrayList<Contact> jsonContacts = new JsonableArrayList<Contact>();
        for (Contact c : rawContacts) {
            jsonContacts.add(c);
        }
        renderJSON(jsonContacts.toJson("contacts"));
    }

    public static void loadContactsFromDatabaseByTag(String tag) {
        List<Contact> rawContacts = Contact.findTaggedWith(tag);
        JsonableArrayList<Contact> jsonContacts = new JsonableArrayList<Contact>();
        for (Contact c : rawContacts) {
            jsonContacts.add(c);
        }
        renderJSON(jsonContacts.toJson("contacts"));
    }

    private static String formatObjectvalueString(String str) {
        return (str != null) ? "\"" + str + "\"" : "null";
    }

}
