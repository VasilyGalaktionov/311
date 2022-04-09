package com.example.boot.dao;

import java.util.List;

public interface UserDao {
    List<User> allUsers();
    void add(User user);
    void delete(int id);
    void edit(User user);
    User getById(int id);
}
