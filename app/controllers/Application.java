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

    private static String formatObjectvalueString(String str) {
        return (str != null) ? "\"" + str + "\"" : "null";
    }

}
