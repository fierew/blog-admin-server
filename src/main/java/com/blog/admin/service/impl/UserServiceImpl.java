package com.blog.admin.service.impl;

import com.blog.admin.dao.UserDao;
import com.blog.admin.model.UserModel;
import com.blog.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuyang
 */
@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public void setUserMapper(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public List<UserModel> getUsers(int page, int pageSize) {
        return null;
    }

    @Override
    public UserModel getUser(Integer id) {
        return null;
    }

    @Override
    public int addUser(UserModel userModel) {
        return 0;
    }

    @Override
    public int modifyUser(int id, UserModel userModel) {
        return 0;
    }

    @Override
    public int delUser(int id) {
        return 0;
    }
}
