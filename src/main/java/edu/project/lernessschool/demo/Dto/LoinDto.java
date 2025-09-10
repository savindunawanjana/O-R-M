package edu.project.lernessschool.demo.Dto;

import edu.project.lernessschool.demo.Entyty.UserEntyty;

public class LoinDto {

  private String Password;
    private String Username;

    public LoinDto(String password, String username) {
        Password = password;
        Username = username;
    }

    public LoinDto() {
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
