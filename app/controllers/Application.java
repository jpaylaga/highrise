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
        JsonableArrayList<Contact> contacts = ContactsFactory.createFromTag(tag, "joshuapaylaga", "2b67f902fd7566e5c1cfdecc4969aa98");
        renderJSON(contacts.toJson("contacts"));
    }

    private static String formatObjectvalueString(String str) {
        return (str != null) ? "\"" + str + "\"" : "null";
    }

}
