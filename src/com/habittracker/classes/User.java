package com.habittracker.classes;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {
    private int userId; // make a class to generate unique ids
    private String name;
    private String email;
    private String pass; // todo is password included here?

    public static ArrayList<Habit> habitList = new ArrayList<>();

    public static ArrayList<User> friendList = new ArrayList<>();

    public User() {
    }

    public User(int userId, String name, String email, String pass, ArrayList habitList, ArrayList friendList) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.habitList = habitList;
        this.friendList = friendList;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public static void setUserId() {

    }

    public static void setName() {

    }

    public static void setEmail() {

    }

    public static void setPass() {

    }


}
