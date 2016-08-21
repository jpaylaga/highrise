package models.xml;

import org.simpleframework.xml.*;

@Root(name="subject_data")
public class SubjectData {

    @Element
    private int id;

    @Element(name="subject_field_id")
    private int subjectFieldId;

    @Element(name="subject_field_label")
    private String subjectFieldLabel;

    @Element
    private String value;

    public SubjectData(int id, int subjectFieldId, String subjectFieldLabel, String value) {
        this.id                = id;
        this.subjectFieldId    = subjectFieldId;
        this.subjectFieldLabel = subjectFieldLabel;
        this.value             = value;
    }

    public int getId() {
        return this.id;
    }

    public int getSubjectFieldId() {
        return this.subjectFieldId;
    }

    public String getSubjectFieldLabel() {
        return this.subjectFieldLabel;
    }

    public String getValue() {
        return this.value;
    }
}
