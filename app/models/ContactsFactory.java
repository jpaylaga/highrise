package models;

import java.util.*;
import java.text.*;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import org.simpleframework.xml.*;
import org.simpleframework.xml.core.*;
import org.simpleframework.xml.transform.*;

import models.jpa.Contact;

import models.xml.*;
import models.xml.DateFormatTransformer;
import models.JsonableArrayList;

public class ContactsFactory {

    public static JsonableArrayList<Contact> create(String username, String apiKey) {
        JsonableArrayList<Contact> contacts = new JsonableArrayList<Contact>();
        try {
            contacts = generateContactsFromEntity(
                getEntityFromApi("people.xml", username, apiKey)
            );
        } catch (Exception e) {
            System.out.println(e);
        }

        return contacts;
    }

    public static JsonableArrayList<Contact> createFromTag(String tag, String username, String apiKey) {
        int tagId = 0;
        JsonableArrayList<Contact> contacts = new JsonableArrayList<Contact>();

        // Parse tags XML from highrise
        try {
            String entity1 = getEntityFromApi("tags.xml", username, apiKey);
            Serializer serializer = new Persister();
            Tags tags = serializer.read(Tags.class, entity1);

            String lTag = tag.toLowerCase();
            for (Tag t : tags.getTags()) {
                String iTag = t.getName().toLowerCase();
                if (lTag.equals(iTag)) {
                    tagId = t.getId();
                    break;
                }
            }

            if (tagId > 0) {
                contacts = generateContactsFromEntity(
                    getEntityFromApiWithQueryParamsIntValue("people.xml", "tag_id", tagId, username, apiKey)
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return contacts;
    }

    private static String getEntityFromApi(String path, String username, String apiKey) throws Exception {
        String basicAuth = Base64.getEncoder().encodeToString((apiKey + ":x").getBytes("utf-8"));
        String apiUrl = "https://" + username + ".highrisehq.com";
        Client client = ClientBuilder.newClient();
        String entity = client.target(apiUrl)
                        .path(path)
                        .request(MediaType.APPLICATION_XML)
                        .header("authorization", "Basic " + basicAuth)
                        .get(String.class);

        return entity;
    }

    private static String getEntityFromApiWithQueryParamsIntValue(
        String path,
        String qVariable,
        int    qValue,
        String username,
        String apiKey
    ) throws Exception {

        String basicAuth = Base64.getEncoder().encodeToString((apiKey + ":x").getBytes("utf-8"));
        String apiUrl = "https://" + username + ".highrisehq.com";
        Client client = ClientBuilder.newClient();
        String entity = client.target(apiUrl)
                        .path(path)
                        .queryParam(qVariable, qValue)
                        .request(MediaType.APPLICATION_XML)
                        .header("authorization", "Basic " + basicAuth)
                        .get(String.class);

        return entity;
    }

    private static JsonableArrayList<Contact> generateContactsFromEntity(String entity) throws Exception {
        JsonableArrayList<Contact> contacts = new JsonableArrayList<Contact>();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        RegistryMatcher matcher = new RegistryMatcher();
        matcher.bind(Date.class, new DateFormatTransformer(format));
        Serializer serializer = new Persister(matcher);
        People people = serializer.read(People.class, entity);
        for (Person person : people.getPersons()) {
            contacts.add(parsePersonToContact(person));
        }

        return contacts;
    }

    private static Contact parsePersonToContact(Person person) {
        Contact contact = new Contact(
            person.getFirstName(),
            person.getLastName(),
            person.getCreatedAt(),
            person.getUpdatedAt()
        );

        contact.setTitle(person.getTitle());
        contact.setCompanyName(person.getCompanyName());
        contact.setBackground(person.getBackground());
        contact.setLinkedinUrl(person.getLinkedinUrl());
        contact.setInstantMessengerProtocol(
            (person.getContactData().getInstantMessengers().size() > 0)
            ? person.getContactData().getInstantMessengers().get(0).getProtocol()
            : null
        );
        contact.setInstantMessengerAddress(
            (person.getContactData().getInstantMessengers().size() > 0)
            ? person.getContactData().getInstantMessengers().get(0).getAddress()
            : null
        );
        contact.setEmailAddress(
            (person.getContactData().getEmailAddresses().size() > 0)
            ? person.getContactData().getEmailAddresses().get(0).getAddress()
            : null
        );
        contact.setTwitterAccount(
            (person.getContactData().getTwitterAccounts().size() > 0)
            ? person.getContactData().getTwitterAccounts().get(0).getUsername()
            : null
        );
        contact.setAddress(
            (person.getContactData().getAddresses().size() > 0)
            ? addressToString(person.getContactData().getAddresses().get(0))
            : null
        );
        contact.setWebAddress(
            (person.getContactData().getWebAddresses().size() > 0)
            ? person.getContactData().getWebAddresses().get(0).getUrl()
            : null
        );

        for (Tag tag : person.getTags()) {
            contact.addTag(tag.getName());
        }

        return contact;
    }

    private static String addressToString(Address address) {
        String sep = ", ";
        String strAddress = address.getStreet() + sep +
                            address.getCity() + sep +
                            address.getState() + sep +
                            Integer.toString(address.getZip()) + sep +
                            address.getCountry();

        return strAddress;
    }
}
