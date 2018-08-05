package com.teamproject.bet4life.repositories;

import com.teamproject.bet4life.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUsers();

    User getUserByID(int id);

    boolean registerUser(User u);

}