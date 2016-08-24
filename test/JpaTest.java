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
    public void saveContactTest() {

        // Save contact
        Date currTime = new Date();
        Contact contact = new Contact("Joshua", "Paylaga", currTime, currTime);
        contact.save();

        // Retrieve contact
        Contact retContact = Contact.find("byLastName", contact.getLastName()).first();
        assertEquals(contact.getFirstName(), retContact.getFirstName());
        assertEquals(contact.getLastName(), retContact.getLastName());
    }
}
