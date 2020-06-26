package com.blog.admin.dto;

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
