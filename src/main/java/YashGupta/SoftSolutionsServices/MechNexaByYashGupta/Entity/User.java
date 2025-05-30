package YashGupta.SoftSolutionsServices.MechNexaByYashGupta.Entity;


import YashGupta.SoftSolutionsServices.MechNexaByYashGupta.Enums.Gender;
import YashGupta.SoftSolutionsServices.MechNexaByYashGupta.Enums.Role;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User {


    @Id
    private ObjectId id;

    @NonNull
    @Indexed(unique = true)
    private String userid;

    @NonNull
    private String username;

    @NonNull
    private Gender gender;

    @NonNull
    private String password;

    @NonNull
    @Indexed(unique = true)
    private String gmail;

    @NonNull
    @Indexed(unique = true)
    private String phonenumber;

    @NonNull
    private Role role;

    public @NonNull String getUserid() {
        return userid;
    }

    public void setUserid(@NonNull String userid) {
        this.userid = userid;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public @NonNull String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public @NonNull Gender getGender() {
        return gender;
    }

    public void setGender(@NonNull Gender gender) {
        this.gender = gender;
    }

    public @NonNull String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public @NonNull String getGmail() {
        return gmail;
    }

    public void setGmail(@NonNull String gmail) {
        this.gmail = gmail;
    }

    public @NonNull String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(@NonNull String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public @NonNull Role getRole() {
        return role;
    }

    public void setRole(@NonNull Role role) {
        this.role = role;
    }
}
