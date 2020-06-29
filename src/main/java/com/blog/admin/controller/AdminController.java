package com.blog.admin.controller;

import com.blog.admin.annotation.PassToken;
import com.blog.admin.dto.Result;
import com.blog.admin.model.MenuModel;
import com.blog.admin.utils.JwtUtils;
import com.blog.admin.utils.MenuTreeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AdminController {
    @PassToken
    @PostMapping("/login")
    Result login(@RequestParam(name = "username") String username,
                 @RequestParam(name = "password") String password) {
        String token = JwtUtils.sign(1, username, "admin");
        Result result = new Result();
        result.setCode(200);
        result.setMsg("success");
        Map<String, String> maps = new HashMap<>();
        maps.put("token", token);

        result.setData(maps);

        return result;
    }

    @PassToken
    @PostMapping("/register")
    Result register() {
        return new Result();
    }

    @PassToken
    @GetMapping("/menu")
    Result menu() {

        Result result = new Result();
        result.setCode(200);
        result.setMsg("success");

        List<MenuModel> menuList = new ArrayList<>();

        /*插入一些数据*/
        menuList.add(new MenuModel(1, 0, "系统管理", "icon", 0, "key", "/admin", 1, 1000000, 100000));
        menuList.add(new MenuModel(2, 1, "权限管理", "icon", 0, "key", "/admin", 1, 1000000, 100000));
        menuList.add(new MenuModel(3, 1, "密码修改", "icon", 0, "key", "/admin", 1, 1000000, 100000));
        menuList.add(new MenuModel(4, 1, "新加用户", "icon", 0, "key", "/admin", 1, 1000000, 100000));
        menuList.add(new MenuModel(5, 1, "系统监控", "icon", 0, "key", "/admin", 1, 1000000, 100000));
        menuList.add(new MenuModel(6, 3, "在线用户", "icon", 0, "key", "/admin", 1, 1000000, 100000));
        menuList.add(new MenuModel(7, 6, "订阅区", "icon", 0, "key", "/admin", 1, 1000000, 100000));
        menuList.add(new MenuModel(8, 5, "未知领域", "icon", 0, "key", "/admin", 1, 1000000, 100000));
        ;
        /*让我们创建树*/
        MenuTreeUtils menuTree = new MenuTreeUtils(menuList);
        menuList = menuTree.buildTree();


        result.setData(menuList);
        return result;
    }
}
