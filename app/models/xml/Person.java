package models.xml;

import java.util.*;
import java.text.*;
import org.simpleframework.xml.*;

@Root
public class Person {

    @Element(name="id")
    private int personId;

    @Element(name="author-id")
    private int authorId;

    @Element(name="company-id", required=false)
    private int companyId;

    @Element(name="owner-id", required=false)
    private int ownerId;

    @Element(name="group-id", required=false)
    private int groupId;

    @Element(name="first-name")
    private String firstName;

    @Element(name="last-name")
    private String lastName;

    @Element(required=false)
    private String title;

    @Element(name="company-name", required=false)
    private String companyName;

    @Element(required=false)
    private String background;

    @Element(name="visible-to")
    private String visibleTo;

    @Element(name="linkedin-url", required=false)
    private String linkedinUrl;

    @Element(name="avatar_url")
    private String avatarUrl;

    @Element(name="created-at")
    private Date createdAt;

    @Element(name="updated-at")
    private Date updatedAt;

    @Element(name="contact-data")
    private ContactData contactData;

    @ElementList(required=false)
    private List<Tag> tags;

    @ElementList(name="subject_datas", required=false)
    private List<SubjectData> subjectDatas;

    public Person() {
        this.tags         = new ArrayList<Tag>();
        this.subjectDatas = new ArrayList<SubjectData>();
    }

    public Person(
        int               personId,
        int               authorId,
        String            firstName,
        String            lastName,
        String            visibleTo,
        String            avatarUrl,
        String            createdAt,
        String            updatedAt,
        ContactData       contactData
    ) {
        this.tags         = new ArrayList<Tag>();
        this.subjectDatas = new ArrayList<SubjectData>();

        this.setPersonId(personId);
        this.setAuthorId(authorId);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setVisibleTo(visibleTo);
        this.setAvatarUrl(avatarUrl);
        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
        this.setContactData(contactData);
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getPersonId() {
        return this.personId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getAuthorId() {
        return this.authorId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getCompanyId() {
        return this.companyId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getOwnerId() {
        return this.ownerId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getGroupId() {
        return this.groupId;
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

    public void setVisibleTo(String visibleTo) {
        this.visibleTo = visibleTo;
    }

    public String getVisibleTo() {
        return this.visibleTo;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getLinkedinUrl() {
        return this.linkedinUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = this.stringToDate(createdAt);
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = this.stringToDate(updatedAt);
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setContactData(ContactData contactData) {
        this.contactData = contactData;
    }

    public ContactData getContactData() {
        return this.contactData;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public void addSubjectData(SubjectData subjectData) {
        this.subjectDatas.add(subjectData);
    }

    public List<SubjectData> getSubjectDatas() {
        return this.subjectDatas;
    }

    private Date stringToDate(String dateStr) {
        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        return date;
    }
}
