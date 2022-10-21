package com.example.user_store;


import org.springframework.stereotype.Component;

import javax.validation.constraints.Pattern;

@Component
class User {
    private String username;
    private String password;
    @Pattern(regexp = "^(ROLE_).*?$")
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
