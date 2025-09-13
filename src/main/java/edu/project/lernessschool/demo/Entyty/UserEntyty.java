package edu.project.lernessschool.demo.Entyty;


import jakarta.persistence.*;

@Entity
@Table(name = "user_table")
//@IdClass(User.class)
public class UserEntyty {

    @Id
    private String Userid;

    @Column(nullable = false, unique = true,length = 100)
    private String password;

    @Column(nullable = false, unique = true)
    private String contact_number;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    private String userroll;

    public UserEntyty() {}

    public UserEntyty(String Userid,String username, String password, String userroll, String contact_number, String email) {
        this.Userid = Userid;
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

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }

    public String getUserroll() {
        return userroll;
    }

    public void setUserroll(String userroll) {
        this.userroll = userroll;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
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
