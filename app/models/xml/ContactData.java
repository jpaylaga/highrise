package models.xml;

import java.util.*;
import org.simpleframework.xml.*;

public class ContactData {

    @ElementList(name="instant-messengers", required=false)
    private List<InstantMessenger> instantMessengers;

    @ElementList(name="phone-numbers", required=false)
    private List<PhoneNumber> phoneNumbers;

    @ElementList(name="email-addresses", required=false)
    private List<EmailAddress> emailAddresses;

    @ElementList(name="twitter-accounts", required=false)
    private List<TwitterAccount> twitterAccounts;

    @ElementList(required=false)
    private List<Address> addresses;

    @ElementList(name="web-addresses", required=false)
    private List<WebAddress> webAddresses;

    public ContactData() {
        this.instantMessengers = new ArrayList<InstantMessenger>();
        this.phoneNumbers      = new ArrayList<PhoneNumber>();
        this.emailAddresses    = new ArrayList<EmailAddress>();
        this.twitterAccounts   = new ArrayList<TwitterAccount>();
        this.addresses         = new ArrayList<Address>();
        this.webAddresses      = new ArrayList<WebAddress>();
    }

    public void addInstantMessenger(InstantMessenger instantMessenger) {
        this.instantMessengers.add(instantMessenger);
    }

    public List<InstantMessenger> getInstantMessengers() {
        return this.instantMessengers;
    }

    public void addPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public void addEmailAddress(EmailAddress emailAddress) {
        this.emailAddresses.add(emailAddress);
    }

    public List<EmailAddress> getEmailAddresses() {
        return this.emailAddresses;
    }

    public void addTwitterAccount(TwitterAccount twitterAccount) {
        this.twitterAccounts.add(twitterAccount);
    }

    public List<TwitterAccount> getTwitterAccounts() {
        return this.twitterAccounts;
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    public List<Address> getAddresses() {
        return this.addresses;
    }

    public void addWebAddress(WebAddress webAddress) {
        this.webAddresses.add(webAddress);
    }

    public List<WebAddress> getWebAddresses() {
        return this.webAddresses;
    }
}
