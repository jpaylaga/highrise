package models.jpa;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Contact extends Model {

    private String firstName;
    private String lastName;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String background;

    @Column(nullable = false)
    private String linkedinUrl;

    @Column(nullable = false)
    private String instantMessenger;

    @Column(nullable = false)
    private String emailAddress;

    @Column(nullable = false)
    private String twitterAccount;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String webAddress;

    private Date createdAt;
    private Date updatedAt;

    public Contact(String firstName, String lastName, Date createdAt, Date updatedAt) {
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

    public void setInstantMessenger(String instantMessenger) {
        this.instantMessenger = instantMessenger;
    }

    public String getInstantMessenger() {
        return this.instantMessenger;
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
}
