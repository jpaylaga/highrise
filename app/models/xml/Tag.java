package models.xml;

import org.simpleframework.xml.*;

@Root
public class Tag {

    @Element
    private int id;

    @Element
    private String name;

    public Tag(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
