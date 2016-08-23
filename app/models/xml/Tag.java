package models.xml;

import org.simpleframework.xml.*;

@Root
public class Tag {

    @Element
    private int id;

    @Element
    private String name;

    public Tag(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
