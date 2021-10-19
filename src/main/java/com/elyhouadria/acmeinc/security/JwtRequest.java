package com.elyhouadria.acmeinc.security;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class JwtRequest {

/*    @Email*/
    private String username;
/*    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).{6,254}$",
            message = "Please enter a valid password.")*/
    private String password;

    public JwtRequest(){}

    public JwtRequest(String username, String password){
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "JwtRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
