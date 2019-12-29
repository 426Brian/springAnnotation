package com.sprAnnotation.service;

import com.sprAnnotation.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void insertUser(){
        userDao.insert();
    }
}
