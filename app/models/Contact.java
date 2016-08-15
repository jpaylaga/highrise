package models;

import org.simpleframework.xml.*;

@Root(name="person")
public class Contact {

    @Element(name="id")
    private int contactId;

    @Element(name="author-id")
    private int authorId;

    @Element(name="company-id", required=false)
    private int companyId;

    @Element(name="first-name")
    private String firstName;

    @Element(name="last-name")
    private String lastName;

    @Element
    private String title;

    @Element(required=false)
    private String background;

    @Element(name="avatar_url", required=false)
    private String avatarUrl;

    @Element(name="group-id")
    private String groupId;

    public Contact(
        int contactId,
        int authorId,
        int companyId,
        String firstName,
        String lastName,
        String title,
        String background,
        String avatarUrl
    ) {
        this.contactId = contactId;
        this.authorId = authorId;
        this.companyId = companyId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.background = background;
        this.avatarUrl = avatarUrl;
    }

    public int getContactId() {
        return this.contactId;
    }

    public int getAuthorId() {
        return this.authorId;
    }

    public int getCompanyId() {
        return this.companyId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getTitle() {
        return this.title;
    }

    public String getBackground() {
        return this.background;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }
}
