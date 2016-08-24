import org.junit.*;
import java.util.*;
import play.test.*;
import models.jpa.*;
import models.ContactsFactory;

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

    @Test
    public void addTagsToContactTest() {
        Date currTime = new Date();
        Contact contact = new Contact("Joshua", "Paylaga", currTime, currTime);
        contact.addTag("personal");
        contact.save();

        Tag tag = Tag.find("byName", "personal").first();
        assertNotNull(tag);
        assertEquals("personal", tag.getName());
    }

    @Test
    public void findContactsWithTagTest() {
        Date currTime = new Date();
        Contact contact1 = new Contact("Joshua", "Paylaga", currTime, currTime);
        Contact contact2 = new Contact("Kris Ann", "bachinela", currTime, currTime);

        contact1.addTag("personal");
        contact2.addTag("personal");
        contact1.addTag("cs");

        contact1.save();
        contact2.save();

        List<Contact> personal = Contact.findTaggedWith("personal");
        List<Contact> cs = Contact.findTaggedWith("cs");

        assertEquals(2, personal.size());
        assertEquals(1, cs.size());

        assertEquals(2, contact1.getTags().size());
        assertEquals(1, contact2.getTags().size());
    }

    @Test
    public void createContactsFromXML() {
        List<Contact> contacts = ContactsFactory.create("joshuapaylaga", "2b67f902fd7566e5c1cfdecc4969aa98");
        assertEquals(2, contacts.size());
        assertEquals("Marron Christopher", contacts.get(0).getFirstName());
        assertEquals("Afable", contacts.get(0).getLastName());
        assertEquals("Kris Ann", contacts.get(1).getFirstName());
        assertEquals("Bachinela", contacts.get(1).getLastName());

        Contact krisAnn = contacts.get(1);
        assertEquals("Student", krisAnn.getTitle());
        assertEquals("Misamis University", krisAnn.getCompanyName());
        assertEquals("My girlfriend.", krisAnn.getBackground());
        assertEquals("https://ph.linkedin.com/in/joshua-paylaga-76959b6b", krisAnn.getLinkedinUrl());
        assertEquals("Yahoo", krisAnn.getInstantMessengerProtocol());
        assertEquals("kselann", krisAnn.getInstantMessengerAddress());
        assertEquals("krisannbachinela@gmail.com", krisAnn.getEmailAddress());
        assertEquals("kidongladz", krisAnn.getTwitterAccount());
        assertEquals("San Roque, Panaon, Misamis Oriental, 7205, Philippines", krisAnn.getAddress());
        assertEquals("http://krisannbachinela.blogspot.com/2015/11/my-autobiography-am-kris-ann-balt.html", krisAnn.getWebAddress());
        assertEquals(1, krisAnn.getTags().size());
    }
}
