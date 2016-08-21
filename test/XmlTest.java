import org.junit.*;
import java.util.*;
import java.io.File;
import play.test.*;
import models.*;
import models.xml.*;

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
}
