package com.blog.admin.entity;

import lombok.Data;

/**
 * @author xuyang
 */
@Data
public class Result {
    private Integer code;
    private Object data;
    private String msg;
}
