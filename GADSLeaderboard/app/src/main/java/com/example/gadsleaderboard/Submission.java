package com.example.gadsleaderboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Submission {
    public Submission(String email, String name, String lastName, String link) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.link = link;
    }

    private String email;
    private String name;
    private String lastName;
    private String link;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLink() {
        return link;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
