package com.blog.admin.model;

import lombok.Data;

import java.util.List;

@Data
public class MenuModel {
    private Integer id;
    private Integer parentId;
    private String name;
    private String icon;
    private Integer sort;
    private String key;
    private String path;
    private Integer state;
    private Integer updateTime;
    private Integer createTime;
    private List<MenuModel> children;

    public MenuModel(Integer id, Integer parentId, String name, String icon, Integer sort, String key, String path, Integer state, Integer updateTime, Integer createTime) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.icon = icon;
        this.sort = sort;
        this.key = key;
        this.path = path;
        this.state = state;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }
}
