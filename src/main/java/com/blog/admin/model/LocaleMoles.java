package com.blog.admin.model;

import lombok.Data;

/**
 * @author xuyang
 */
@Data
public class LocaleMoles {
    private String key;
    private String value;

    public LocaleMoles(String key,String value){
        this.key = key;
        this.value = value;
    }
}
