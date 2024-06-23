package com.project.examandroid.network;

import com.project.examandroid.model.Contact;

import java.util.List;

public class UserResponse {
    private List<Contact> users;

    public List<Contact> getUsers() {
        return users;
    }

    public void setUsers(List<Contact> users) {
        this.users = users;
    }
}
