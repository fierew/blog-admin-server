package com.blog.admin.dao;

import com.blog.admin.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xuyang
 */
@Mapper
public interface UserDao {
    /**
     * 获取所有用户
     *
     * @param page
     * @param pageSize
     * @return
     */
    List<UserModel> getUsers(int page, int pageSize);

    /**
     * 获取用户
     *
     * @param id
     * @return
     */
    UserModel getUser(Integer id);

    /**
     * 新增用户
     *
     * @param userModel
     * @return
     */
    int addUser(UserModel userModel);

    /**
     * 修改用户
     *
     * @param id
     * @param userModel
     * @return
     */
    int modifyUser(int id, UserModel userModel);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    int delUser(int id);
}
