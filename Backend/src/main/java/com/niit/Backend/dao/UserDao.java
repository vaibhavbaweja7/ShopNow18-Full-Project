package com.niit.Backend.dao;

import java.util.List;

import com.niit.Backend.model.User;

public interface UserDao {
public boolean addUser(User user);
public boolean updateUser(User user);
public boolean deleteUser(int userId); 
public User getUser(int userId);
public List<User> getAllUsers();
public List<User> retrieveUser();


}
