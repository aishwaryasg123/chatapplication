package com.assignment.test.Repositorys;

import org.springframework.data.repository.Repository;

import com.assignment.test.models.User;

import java.util.List;

public interface UserRepository extends Repository<User, Integer> {

    void delete(User user);

    List<User> findAll();

    User findOne(int id);

    User save(User user);

	User findByEmail(String email);
}
