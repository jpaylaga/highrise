package models;

import java.util.ArrayList;

public class JsonableArrayList<T extends JsonInterface> extends ArrayList<T> implements JsonInterface {

    public String toJson() {
        String json = "[";
        for (int i = 0; i < size(); i++) {
            T t = get(i);
            json += t.toJson();
            if (i < (size() - 1)) {
                json += ", ";
            }
        }
        json += "]";

        return json;
    }

    public String toJson(String parent) {
        String json = "{\"" + parent + "\":";
        json += this.toJson();
        json += "}";

        return json;
    }
}
