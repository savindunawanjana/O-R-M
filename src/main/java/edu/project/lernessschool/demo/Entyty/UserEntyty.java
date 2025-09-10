package edu.project.lernessschool.demo.Entyty;


import jakarta.persistence.*;

@Entity
@Table(name = "user_table")
//@IdClass(User.class)
public class UserEntyty {

    @Id
    private String password;

    private int contact_number;
    private String email;
    private String username;
    private String userroll;


    public UserEntyty() {}

    public UserEntyty(String username, String password, String userroll, int contact_number, String email) {
        this.username = username;
        this.password = password;
        this.userroll = userroll;
        this.contact_number = contact_number;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserroll() {
        return userroll;
    }

    public void setUserroll(String userroll) {
        this.userroll = userroll;
    }

    public int getContact_number() {
        return contact_number;
    }

    public void setContact_number(int contact_number) {
        this.contact_number = contact_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserEntyty{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", userroll='" + userroll + '\'' +
                ", contact_number=" + contact_number +
                ", email='" + email + '\'' +
                '}';
    }
}
