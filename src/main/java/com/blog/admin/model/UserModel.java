package com.blog.admin.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author xuyang
 */
@Data
public class UserModel {
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;
    private String username;
    private String password;
}
