package edu.project.lernessschool.demo.Dto;

public class UserDto {

    private String Userid;
    private String password;
    private String contact_number;
    private String email;
    private String username;
    private String userroll;


    public UserDto(String userid,String password, String contact_number, String email, String username, String userroll) {
        this.Userid=userid;
        this.password = password;
        this.contact_number = contact_number;
        this.email = email;
        this.username = username;
        this.userroll = userroll;
    }

    public UserDto() {
    }

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserroll() {
        return userroll;
    }

    public void setUserroll(String Userroll) {
        this.userroll = Userroll;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "password='" + password + '\'' +
                ", contact_number=" + contact_number +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", userroll='" + userroll + '\'' +
                '}';
    }
}
