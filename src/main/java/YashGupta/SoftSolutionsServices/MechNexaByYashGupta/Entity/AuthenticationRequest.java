package YashGupta.SoftSolutionsServices.MechNexaByYashGupta.Entity;


import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AuthenticationRequest {


    private String id;

    private String password;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}