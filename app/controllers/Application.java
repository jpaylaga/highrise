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
        render();
    }

    public static void loadContactsByTag(String tag) {
        try {
            JsonableArrayList<Contact> contacts = ContactsFactory.createFromTag(tag, "joshuapaylaga", "2b67f902fd7566e5c1cfdecc4969aa98");
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
