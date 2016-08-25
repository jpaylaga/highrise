package models.jpa;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

import models.JsonInterface;

@Entity
public class Tag extends Model implements Comparable<Tag>, JsonInterface {

    private String name;

    public Tag(String name) {
        this.setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.getName();
    }

    public int compareTo(Tag otherTag) {
        return this.getName().compareTo(otherTag.getName());
    }

    public String toJson() {
        return "{\"name\":" + ((this.getName() != null) ? "\"" + this.getName() + "\"" : "null") + "}";
    }

    public static Tag findOrCreateByName(String name) {
        Tag tag = Tag.find("byName", name).first();
        if(tag == null) {
            tag = new Tag(name);
        }

        return tag;
    }
}
