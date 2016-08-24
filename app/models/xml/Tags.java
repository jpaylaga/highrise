package models.xml;

import java.util.*;
import org.simpleframework.xml.*;

@Root
public class Tags {

    @ElementList(inline=true, name="tag")
    private List<Tag> tags;

    @Attribute
    private String type;

    public Tags(String type) {
        this.tags = new ArrayList<Tag>();
        this.setType(type);
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
