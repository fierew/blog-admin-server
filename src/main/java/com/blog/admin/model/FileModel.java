package com.blog.admin.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author xuyang
 */
@Data
public class FileModel {
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;
    @JsonSerialize(using= ToStringSerializer.class)
    private Long userId;
    private String name;
    private String type;
    private String path;
    @JsonSerialize(using= ToStringSerializer.class)
    private Long size;
    private String hash;
    private Byte isDelete;
    private Integer createTime;
    private Integer updateTime;
}
