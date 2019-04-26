package com.assignment.test.Services;

import java.util.List;

import com.assignment.test.models.User;

public interface UserService {

    User create(User user);

    User delete(int id);
    User findByEmail(String email);

    List<User> findAll();

    User findById(int id);

    User update(User user);

}
