package com.blog.admin.dao;

import com.blog.admin.model.AdminModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xuyang
 */
@Mapper
public interface AdminDao {
    /**
     * 获取所有管理员
     *
     * @param page
     * @param pageSize
     * @return
     */
    List<AdminModel> getAdmins(int page, int pageSize);
}
