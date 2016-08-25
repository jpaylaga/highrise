package models.jpa;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

import models.*;

@Entity
public class Contact extends Model implements JsonInterface {

    private String firstName;
    private String lastName;

    @Column(nullable = true)
    private String title;

    @Column(nullable = true)
    private String companyName;

    @Column(nullable = true)
    private String background;

    @Column(nullable = true)
    private String linkedinUrl;

    @Column(nullable = true)
    private String instantMessengerProtocol;

    @Column(nullable = true)
    private String instantMessengerAddress;

    @Column(nullable = true)
    private String emailAddress;

    @Column(nullable = true)
    private String twitterAccount;

    @Column(nullable = true)
    private String address;

    @Column(nullable = true)
    private String webAddress;

    @ManyToMany(cascade=CascadeType.PERSIST)
    private Set<Tag> tags;

    private Date createdAt;
    private Date updatedAt;

    public Contact(String firstName, String lastName, Date createdAt, Date updatedAt) {
        this.tags = new TreeSet<Tag>();

        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getBackground() {
        return this.background;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getLinkedinUrl() {
        return this.linkedinUrl;
    }

    public void setInstantMessengerProtocol(String instantMessengerProtocol) {
        this.instantMessengerProtocol = instantMessengerProtocol;
    }

    public String getInstantMessengerProtocol() {
        return this.instantMessengerProtocol;
    }

    public void setInstantMessengerAddress(String instantMessengerAddress) {
        this.instantMessengerAddress = instantMessengerAddress;
    }

    public String getInstantMessengerAddress() {
        return this.instantMessengerAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setTwitterAccount(String twitterAccount) {
        this.twitterAccount = twitterAccount;
    }

    public String getTwitterAccount() {
        return this.twitterAccount;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getWebAddress() {
        return this.webAddress;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = this.createdAt;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void addTag(String tag) {
        this.getTags().add(Tag.findOrCreateByName(tag));
    }

    public Set<Tag> getTags() {
        return this.tags;
    }

    public List<Tag> getTagsAsList() {
        List<Tag> tags = new ArrayList<Tag>();
        for (Tag tag : this.getTags()) {
            tags.add(tag);
        }

        return tags;
    }

    public String toJson() {
        String json = "";
        json += "{";
        json += "\"firstName\":" + this.formatObjectvalueString(this.getFirstName()) + ",";
        json += "\"lastName\":" + this.formatObjectvalueString(this.getLastName()) + ",";
        json += "\"title\":" + this.formatObjectvalueString(this.getTitle()) + ",";
        json += "\"companyName\":" + this.formatObjectvalueString(this.getCompanyName()) + ",";
        json += "\"background\":" + this.formatObjectvalueString(this.getBackground()) + ",";
        json += "\"linkedinUrl\":" + this.formatObjectvalueString(this.getLinkedinUrl()) + ",";
        json += "\"instantMessengerProtocol\":" + this.formatObjectvalueString(this.getInstantMessengerProtocol()) + ",";
        json += "\"instantMessengerAddress\":" + this.formatObjectvalueString(this.getInstantMessengerAddress()) + ",";
        json += "\"emailAddress\":" + this.formatObjectvalueString(this.getEmailAddress()) + ",";
        json += "\"twitterAccount\":" + this.formatObjectvalueString(this.getTwitterAccount()) + ",";
        json += "\"address\":" + this.formatObjectvalueString(this.getAddress()) + ",";
        json += "\"webAddress\":" + this.formatObjectvalueString(this.getWebAddress());
        json += "}";

        return json;
    }

    public String toJson(String parent) {
        String json = "{\"" + parent + "\":";
        json += this.toJson();
        json += "}";

        return json;
    }

    public static List<Contact> findTaggedWith(String tag) {
        return Contact.find(
            "select distinct c from Contact c join c.tags as t where t.name = (:tag)"
        ).bind("tag", tag).fetch();
    }

    public static boolean hasSame(Contact contact) {
        int count = Contact.find(
            "select c from Contact c where c.firstName = (:firstName) and c.lastName = (:lastName)"
        ).bind("firstName", contact.getFirstName()).bind("lastName", contact.getLastName()).fetch().size();

        return (count > 0) ? true : false;
    }

    private String formatObjectvalueString(String str) {
        return (str != null) ? "\"" + str + "\"" : "null";
    }
}
