package models.xml;

import java.util.*;
import org.simpleframework.xml.*;

@Root
public class People {

    @ElementList(inline=true, name="person")
    private List<Person> persons;

    @Attribute
    private String type;

    public People(String type) {
        this.persons = new ArrayList<Person>();
        this.setType(type);
    }

    public void addPerson(Person person) {
        this.persons.add(person);
    }

    public List<Person> getPersons() {
        return this.persons;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
