package com.example.restTemplate.Services;

import com.example.restTemplate.model.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);
    public User getUser(Integer id);
    public List<User> getAll();
}
