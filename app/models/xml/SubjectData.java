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
        this.setId(id);
        this.setSubjectFieldId(subjectFieldId);
        this.setSubjectFieldLabel(subjectFieldLabel);
        this.setValue(value);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setSubjectFieldId(int subjectFieldId) {
        this.subjectFieldId = subjectFieldId;
    }

    public int getSubjectFieldId() {
        return this.subjectFieldId;
    }

    public void setSubjectFieldLabel(String subjectFieldLabel) {
        this.subjectFieldLabel = subjectFieldLabel;
    }

    public String getSubjectFieldLabel() {
        return this.subjectFieldLabel;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
