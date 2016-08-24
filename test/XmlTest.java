import org.junit.*;
import java.util.*;
import java.text.*;
import java.io.File;
import play.test.*;
import models.*;
import models.xml.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import org.simpleframework.xml.*;
import org.simpleframework.xml.core.*;
import org.simpleframework.xml.transform.*;

public class XmlTest extends UnitTest {

    @Test
    public void createXmlFromClassesTest() {

        // Contact Data

        // Instant Messenger
        InstantMessenger instantMessenger = new InstantMessenger(215123078, "Personal", "Yahoo", "kselann");
        assertEquals(215123078, instantMessenger.getId());
        assertEquals("Personal", instantMessenger.getLocation());
        assertEquals("Yahoo", instantMessenger.getProtocol());
        assertEquals("kselann", instantMessenger.getAddress());

        // Phone Number
        PhoneNumber phoneNumber = new PhoneNumber(214856476, "Mobile", "+639366475621");
        assertEquals(214856476, phoneNumber.getId());
        assertEquals("Mobile", phoneNumber.getLocation());
        assertEquals("+639366475621", phoneNumber.getNumber());

        // Email Address
        EmailAddress emailAddress = new EmailAddress(146641312, "Other", "krisannbachinela@gmail.com");
        assertEquals(146641312, emailAddress.getId());
        assertEquals("Other", emailAddress.getLocation());
        assertEquals("krisannbachinela@gmail.com", emailAddress.getAddress());

        // Twitter Account
        TwitterAccount twitterAccount = new TwitterAccount(215166255, "Other", "kidongladz", "http://twitter.com/kidongladz");
        assertEquals(215166255, twitterAccount.getId());
        assertEquals("Other", twitterAccount.getLocation());
        assertEquals("kidongladz", twitterAccount.getUsername());
        assertEquals("http://twitter.com/kidongladz", twitterAccount.getUrl());

        // Address
        Address address = new Address(130055788, "Home");
        assertNull(address.getCity());
        assertNull(address.getCountry());
        assertNull(address.getState());
        assertNull(address.getStreet());
        assertEquals(0, address.getZip());
        address.setCity("Panaon");
        address.setCountry("Philippines");
        address.setState("Misamis Occidental");
        address.setStreet("San Roque");
        address.setZip(7205);
        assertEquals("Panaon", address.getCity());
        assertEquals("Philippines", address.getCountry());
        assertEquals("Misamis Occidental", address.getState());
        assertEquals("San Roque", address.getStreet());
        assertEquals(7205, address.getZip());

        // Web Address
        WebAddress webAddress = new WebAddress(215123079, "Work", "http://krisannbachinela.blogspot.com/2015/11/my-autobiography-am-kris-ann-balt.html");
        assertEquals(215123079, webAddress.getId());
        assertEquals("Work", webAddress.getLocation());
        assertEquals("http://krisannbachinela.blogspot.com/2015/11/my-autobiography-am-kris-ann-balt.html", webAddress.getUrl());

        ContactData contactData = new ContactData();
        assertEquals(0, contactData.getInstantMessengers().size());
        assertEquals(0, contactData.getPhoneNumbers().size());
        assertEquals(0, contactData.getEmailAddresses().size());
        assertEquals(0, contactData.getTwitterAccounts().size());
        assertEquals(0, contactData.getAddresses().size());
        assertEquals(0, contactData.getWebAddresses().size());
        contactData.addInstantMessenger(instantMessenger);
        contactData.addPhoneNumber(phoneNumber);
        contactData.addEmailAddress(emailAddress);
        contactData.addTwitterAccount(twitterAccount);
        contactData.addAddress(address);
        contactData.addWebAddress(webAddress);
        assertEquals(1, contactData.getInstantMessengers().size());
        assertEquals(1, contactData.getPhoneNumbers().size());
        assertEquals(1, contactData.getEmailAddresses().size());
        assertEquals(1, contactData.getTwitterAccounts().size());
        assertEquals(1, contactData.getAddresses().size());
        assertEquals(1, contactData.getWebAddresses().size());

        // Tags
        Tag tag = new Tag(4858528, "personal");
        assertEquals(4858528, tag.getId());
        assertEquals("personal", tag.getName());

        // Subject Data
        SubjectData subjectData1 = new SubjectData(193302039, 1097820, "Customer ID", "customer_ambot");
        assertEquals(193302039, subjectData1.getId());
        assertEquals(1097820, subjectData1.getSubjectFieldId());
        assertEquals("Customer ID", subjectData1.getSubjectFieldLabel());
        assertEquals("customer_ambot", subjectData1.getValue());

        SubjectData subjectData2 = new SubjectData(193302040, 1097821, "Referred By", "referred_ambot");
        assertEquals(193302040, subjectData2.getId());
        assertEquals(1097821, subjectData2.getSubjectFieldId());
        assertEquals("Referred By", subjectData2.getSubjectFieldLabel());
        assertEquals("referred_ambot", subjectData2.getValue());

        // Person
        Person person = new Person(
            267603714,
            1233658,
            "Kris Ann",
            "Bachinela",
            "Everyone",
            "https://secure.highrisehq.com/avatar_proxy/eJxj4Yhmz2Tm2siaycLk_5kfABXIA1s|e1792c478abd560724a6e44ca4ecb2725c0ec869",
            "2016-08-11T11:46:19Z",
            "2016-08-19T06:17:51Z",
            contactData
        );

        assertEquals(267603714, person.getPersonId());
        assertEquals(1233658, person.getAuthorId());
        assertEquals("Kris Ann", person.getFirstName());
        assertEquals("Bachinela", person.getLastName());
        assertEquals("Everyone", person.getVisibleTo());
        assertEquals("https://secure.highrisehq.com/avatar_proxy/eJxj4Yhmz2Tm2siaycLk_5kfABXIA1s|e1792c478abd560724a6e44ca4ecb2725c0ec869", person.getAvatarUrl());

        // Created At
        assertEquals(2016, person.getCreatedAt().getYear() + 1900);
        assertEquals(8, person.getCreatedAt().getMonth() + 1);
        assertEquals(11, person.getCreatedAt().getDate());
        assertEquals(11, person.getCreatedAt().getHours());
        assertEquals(46, person.getCreatedAt().getMinutes());
        assertEquals(19, person.getCreatedAt().getSeconds());

        // Updated At
        assertEquals(2016, person.getUpdatedAt().getYear() + 1900);
        assertEquals(8, person.getUpdatedAt().getMonth() + 1);
        assertEquals(19, person.getUpdatedAt().getDate());
        assertEquals(6, person.getUpdatedAt().getHours());
        assertEquals(17, person.getUpdatedAt().getMinutes());
        assertEquals(51, person.getUpdatedAt().getSeconds());

        assertEquals(contactData, person.getContactData());

        assertEquals(0, person.getCompanyId());
        assertEquals(0, person.getOwnerId());
        assertEquals(0, person.getGroupId());
        assertNull(person.getTitle());
        assertNull(person.getCompanyName());
        assertNull(person.getBackground());
        assertNull(person.getLinkedinUrl());
        assertEquals(0, person.getTags().size());
        assertEquals(0, person.getSubjectDatas().size());

        // Optional fields
        person.setCompanyId(267603715);
        person.setOwnerId(123456789);
        person.setGroupId(123456789);
        person.setTitle("Student");
        person.setCompanyName("Misamis University");
        person.setBackground("My girlfriend.");
        person.setLinkedinUrl("https://ph.linkedin.com/in/joshua-paylaga-76959b6b");
        person.addTag(tag);
        person.addSubjectData(subjectData1);
        person.addSubjectData(subjectData2);

        assertEquals(267603715, person.getCompanyId());
        assertEquals(123456789, person.getOwnerId());
        assertEquals(123456789, person.getGroupId());
        assertEquals("Student", person.getTitle());
        assertEquals("Misamis University", person.getCompanyName());
        assertEquals("My girlfriend.", person.getBackground());
        assertEquals("https://ph.linkedin.com/in/joshua-paylaga-76959b6b", person.getLinkedinUrl());
        assertEquals(1, person.getTags().size());
        assertEquals(2, person.getSubjectDatas().size());

        // People
        People people = new People("array");
        people.addPerson(person);
        assertEquals(1, people.getPersons().size());
    }

    @Test
    public void createClassesFromXmlTest() {

        // Request to API
        Client client = ClientBuilder.newClient();
        String entity = client.target("https://joshuapaylaga.highrisehq.com")
                        .path("people.xml")
                        .request(MediaType.APPLICATION_XML)
                        .header("authorization", "Basic MmI2N2Y5MDJmZDc1NjZlNWMxY2ZkZWNjNDk2OWFhOTg6WA==")
                        .get(String.class);

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        RegistryMatcher matcher = new RegistryMatcher();
        matcher.bind(Date.class, new DateFormatTransformer(format));
        People people = null;

        Serializer serializer = new Persister(matcher);
        try {
            people = serializer.read(People.class, entity);
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        assertEquals(2, people.getPersons().size());

        Person person1 = people.getPersons().get(0);
        Person person2 = people.getPersons().get(1);

        // Person 1
        assertEquals(267717456, person1.getPersonId());
        assertEquals(1233658, person1.getAuthorId());
        assertEquals(0, person1.getCompanyId());
        assertEquals(0, person1.getOwnerId());
        assertEquals(0, person1.getGroupId());
        assertEquals("Marron Christopher", person1.getFirstName());
        assertEquals("Afable", person1.getLastName());
        assertNull(person1.getTitle());
        assertNull(person1.getCompanyName());
        assertNull(person1.getBackground());
        assertEquals("Everyone", person1.getVisibleTo());
        assertNull(person1.getLinkedinUrl());
        assertEquals("https://secure.highrisehq.com/avatar_proxy/eJxj4Yhmz2Tm2siayRLA_ZUfABY4A2c|8d7c0616420cf91fdd703126cd9f1c021fa6c475", person1.getAvatarUrl());
        assertEquals(2016, person1.getCreatedAt().getYear() + 1900);
        assertEquals(8, person1.getCreatedAt().getMonth() + 1);
        assertEquals(13, person1.getCreatedAt().getDate());
        assertEquals(8, person1.getCreatedAt().getHours());
        assertEquals(18, person1.getCreatedAt().getMinutes());
        assertEquals(32, person1.getCreatedAt().getSeconds());
        assertEquals(2016, person1.getUpdatedAt().getYear() + 1900);
        assertEquals(8, person1.getUpdatedAt().getMonth() + 1);
        assertEquals(19, person1.getUpdatedAt().getDate());
        assertEquals(6, person1.getUpdatedAt().getHours());
        assertEquals(49, person1.getUpdatedAt().getMinutes());
        assertEquals(58, person1.getUpdatedAt().getSeconds());
        assertEquals(0, person1.getContactData().getInstantMessengers().size());
        assertEquals(0, person1.getContactData().getPhoneNumbers().size());
        assertEquals(0, person1.getContactData().getEmailAddresses().size());
        assertEquals(0, person1.getContactData().getTwitterAccounts().size());
        assertEquals(0, person1.getContactData().getAddresses().size());
        assertEquals(0, person1.getContactData().getWebAddresses().size());
        // to be continued...

        // Person 2
        assertEquals(267603714, person2.getPersonId());
        assertEquals(1233658, person2.getAuthorId());
        assertEquals(267603715, person2.getCompanyId());
        assertEquals(0, person2.getOwnerId());
        assertEquals(0, person2.getGroupId());
        assertEquals("Kris Ann", person2.getFirstName());
        assertEquals("Bachinela", person2.getLastName());
        assertEquals("Student", person2.getTitle());
        assertEquals("Misamis University", person2.getCompanyName());
        assertEquals("My girlfriend.", person2.getBackground());
        assertEquals("Everyone", person2.getVisibleTo());
        assertEquals("https://ph.linkedin.com/in/joshua-paylaga-76959b6b", person2.getLinkedinUrl());
        assertEquals("https://secure.highrisehq.com/avatar_proxy/eJxj4Yhmz2Tm2siaycLk_5kfABXIA1s|e1792c478abd560724a6e44ca4ecb2725c0ec869", person2.getAvatarUrl());
        assertEquals(2016, person1.getCreatedAt().getYear() + 1900);
        assertEquals(8, person2.getCreatedAt().getMonth() + 1);
        assertEquals(11, person2.getCreatedAt().getDate());
        assertEquals(11, person2.getCreatedAt().getHours());
        assertEquals(46, person2.getCreatedAt().getMinutes());
        assertEquals(19, person2.getCreatedAt().getSeconds());
        assertEquals(2016, person2.getUpdatedAt().getYear() + 1900);
        assertEquals(8, person2.getUpdatedAt().getMonth() + 1);
        assertEquals(19, person2.getUpdatedAt().getDate());
        assertEquals(6, person2.getUpdatedAt().getHours());
        assertEquals(17, person2.getUpdatedAt().getMinutes());
        assertEquals(51, person2.getUpdatedAt().getSeconds());
        assertEquals(1, person2.getContactData().getInstantMessengers().size());
        assertEquals(1, person2.getContactData().getPhoneNumbers().size());
        assertEquals(1, person2.getContactData().getEmailAddresses().size());
        assertEquals(1, person2.getContactData().getTwitterAccounts().size());
        assertEquals(1, person2.getContactData().getAddresses().size());
        assertEquals(1, person2.getContactData().getWebAddresses().size());
        // to be continued...
    }
}
