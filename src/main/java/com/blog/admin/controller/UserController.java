package com.blog.admin.controller;

import com.blog.admin.entity.Result;
import com.blog.admin.entity.VaUserEntity;
import com.blog.admin.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyang
 */
@Slf4j
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    @Operation(security = { @SecurityRequirement(name = "JWT") })
     public Result findUser(VaUserEntity vaUserEntity){
        Result result = new Result();
        result.setCode(200);
        result.setMsg("Hello World!");
        result.setData(vaUserEntity);
        log.info("info....日志");
        return result;
    }
}
