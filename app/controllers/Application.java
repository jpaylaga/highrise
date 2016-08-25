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
        List<Contact> contacts = ContactsFactory.createFromTag(tag, "joshuapaylaga", "2b67f902fd7566e5c1cfdecc4969aa98");
        renderJSON(contactsToJson(tag, contacts));
    }

    private static String contactsToJson(String tag, List<Contact> contacts) {
        String json = "{\"contacts\":[";
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            json += "{";
            json += "\"firstName\":" + formatObjectvalueString(contact.getFirstName()) + ",";
            json += "\"lastName\":" + formatObjectvalueString(contact.getLastName()) + ",";
            json += "\"title\":" + formatObjectvalueString(contact.getTitle()) + ",";
            json += "\"companyName\":" + formatObjectvalueString(contact.getCompanyName()) + ",";
            json += "\"background\":" + formatObjectvalueString(contact.getBackground()) + ",";
            json += "\"linkedinUrl\":" + formatObjectvalueString(contact.getLinkedinUrl()) + ",";
            json += "\"instantMessengerProtocol\":" + formatObjectvalueString(contact.getInstantMessengerProtocol()) + ",";
            json += "\"instantMessengerAddress\":" + formatObjectvalueString(contact.getInstantMessengerAddress()) + ",";
            json += "\"emailAddress\":" + formatObjectvalueString(contact.getEmailAddress()) + ",";
            json += "\"twitterAccount\":" + formatObjectvalueString(contact.getTwitterAccount()) + ",";
            json += "\"address\":" + formatObjectvalueString(contact.getAddress()) + ",";
            json += "\"webAddress\":" + formatObjectvalueString(contact.getWebAddress());
            json += "}";
            if (i < (contacts.size() - 1)) {
                json += ",";
            }
        }
        json += "]}";

        return json;
    }

    private static String formatObjectvalueString(String str) {
        return (str != null) ? "\"" + str + "\"" : "null";
    }

}
