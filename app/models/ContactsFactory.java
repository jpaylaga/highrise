package models;

import java.util.*;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import org.simpleframework.xml.*;
import org.simpleframework.xml.core.*;
import org.simpleframework.xml.transform.*;

public class ContactsFactory {

    public static void create(String username, String apiKey) {
        try {
            String basicAuth = Base64.getEncoder().encodeToString((apiKey + ":x").getBytes("utf-8"));
            String apiUrl    = "https://" + username + ".highrisehq.com";
            Client client = ClientBuilder.newClient();
            String entity = client.target(apiUrl)
                            .path("people.xml")
                            .request(MediaType.APPLICATION_XML)
                            .header("authorization", "Basic " + basicAuth)
                            .get(String.class);
            System.out.println(entity);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
