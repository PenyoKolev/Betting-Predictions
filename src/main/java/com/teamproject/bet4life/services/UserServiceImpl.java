package com.teamproject.bet4life.services;

import com.teamproject.bet4life.models.User;
import com.teamproject.bet4life.repositories.base.UserRepository;
import com.teamproject.bet4life.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public List<User> getTop3() {
        return this.userRepository.getTop3();
    }

    @Override
    public User getUserByID(int id) {
        return userRepository.getUserByID(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean registerUser(User u) {
        return userRepository.registerUser(u);
    }

    @Override
    public boolean isExistUsername(String username) {
        return userRepository.isExistUsername(username);
    }


    @Override
    public boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException {
        Assert.notNull(fieldName, "Username already exists");

        if (!fieldName.equals("username")) {
            throw new UnsupportedOperationException("Field name not supported");
        }

        if (value == null) {
            return false;
        }
        System.out.println("This is it " + value.toString());
        return this.userRepository.isExistUsername(value.toString());
    }
}
