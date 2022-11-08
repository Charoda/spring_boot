package com.example.springalishev.bootProject.service;



import com.example.springalishev.bootProject.models.User;

import java.util.List;

public interface UserService {


    List<User> index();
    User show(int id);
    void save(User employee);
    void update(int id, User employee);
    void delete(int id);
}
