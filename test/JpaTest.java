import org.junit.*;
import java.util.*;
import play.test.*;
import models.jpa.*;

public class JpaTest extends UnitTest {

    @Before
    public void setup() {
        Fixtures.deleteDatabase();
    }

    @Test
    public void saveContactWithOnlyRequiredFieldsTest() {

        // Save contact
        Date currTime = new Date();
        Contact contact = new Contact("Joshua", "Paylaga", currTime, currTime);
        contact.save();

        // Retrieve contact
        Contact retContact = Contact.find("byLastName", contact.getLastName()).first();
        assertNotNull(retContact);
        assertEquals(contact.getFirstName(), retContact.getFirstName());
        assertEquals(contact.getLastName(), retContact.getLastName());
        assertEquals(contact.getCreatedAt(), retContact.getCreatedAt());
        assertEquals(contact.getUpdatedAt(), retContact.getUpdatedAt());
    }

    @Test
    public void saveContactWithAllFieldsTest() {

        // Save contact
        Date currTime = new Date();
        Contact contact = new Contact("Joshua", "Paylaga", currTime, currTime);

        contact.setTitle("Web Developer");
        contact.setCompanyName("Some Company");
        contact.setBackground("Web Developer with more than 4 years of experience.");
        contact.setLinkedinUrl("https://ph.linkedin.com/in/joshua-paylaga-76959b6b");
        contact.setInstantMessengerProtocol("Skype");
        contact.setInstantMessengerAddress("jpaylaga");
        contact.setEmailAddress("joshuapaylaga@gmail.com");
        contact.setTwitterAccount("jpaylaga");
        contact.setAddress("Corrales Ave., Cagayan de Oro City");
        contact.setWebAddress("http://joshua.greyboxsolutions.co/");

        contact.save();

        // Retrieve contact
        Contact retContact = Contact.find("byLastName", contact.getLastName()).first();
        assertNotNull(retContact);
        assertEquals(contact.getFirstName(), retContact.getFirstName());
        assertEquals(contact.getLastName(), retContact.getLastName());
        assertEquals(contact.getCreatedAt(), retContact.getCreatedAt());
        assertEquals(contact.getUpdatedAt(), retContact.getUpdatedAt());
        assertEquals(contact.getTitle(), retContact.getTitle());
        assertEquals(contact.getCompanyName(), retContact.getCompanyName());
        assertEquals(contact.getBackground(), retContact.getBackground());
        assertEquals(contact.getLinkedinUrl(), retContact.getLinkedinUrl());
        assertEquals(contact.getInstantMessengerProtocol(), retContact.getInstantMessengerProtocol());
        assertEquals(contact.getInstantMessengerAddress(), retContact.getInstantMessengerAddress());
        assertEquals(contact.getEmailAddress(), retContact.getEmailAddress());
        assertEquals(contact.getTwitterAccount(), retContact.getTwitterAccount());
        assertEquals(contact.getAddress(), retContact.getAddress());
        assertEquals(contact.getWebAddress(), retContact.getWebAddress());
    }

    @Test
    public void saveTagTest() {

        Tag tag = new Tag("personal");
        tag.save();

        Tag retTag = Tag.find("byName", tag.getName()).first();
        assertNotNull(retTag);
        assertEquals(tag.getName(), retTag.getName());
    }
}
