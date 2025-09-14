package edu.project.lernessschool.demo.Dto;

public class LoginDto {

  private String Password;
    private String Username;

    public LoginDto(String password, String username) {
        Password = password;
        Username = username;
    }

    public LoginDto() {
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

}
