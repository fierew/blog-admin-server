package com.blog.admin.controller;

import com.blog.admin.annotation.PassToken;
import com.blog.admin.dto.Result;
import com.blog.admin.utils.JwtUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
}
