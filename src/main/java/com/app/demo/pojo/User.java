package com.app.demo.pojo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

public class User {
    private final String name;
    private final String lastName;
    private ArrayList<String> userAnswers = new ArrayList<String>();

    public ArrayList<String> getUserAnswers() {
        return userAnswers;
    }

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "уважаемый " + name + " " + lastName;
    }
}
