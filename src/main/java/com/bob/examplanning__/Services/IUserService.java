package com.bob.examplanning__.Services;

import com.bob.examplanning__.Models.User;

import java.util.List;

public interface IUserService {

    public void addUser(User user);

    public void updateUser(User user);

    public List<User> getAllUsers();

    public void deleteUser(Long id);

    public User getUserById(Long id);

}
