package com.habittracker.controllers;

import com.habittracker.classes.Friends;
import com.habittracker.classes.User;

import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> users = new ArrayList<>(); // make List or set?
    private ArrayList<Friends> friendships = new ArrayList<>();

    public UserManager() {
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUserById(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null; // User not found
    }

    public void addFriendship(Friends friends) {
        friendships.add(friends);
    }

    // Other methods for managing friendships

    // Other user-related methods
}
