package com.blog.admin.service;

import com.blog.admin.entity.FileEntity;
import com.blog.admin.model.FileModel;

/**
 * @author xuyang
 */
public interface FileService {

    /**
     * 检查文件是否上传
     *
     * @param hash sha256
     * @return true或false
     */
    Boolean checkFile(String hash);

    /**
     * 上传文件
     *
     * @param fileEntity 文件数据
     * @return 文件信息
     */
    FileModel upload(FileEntity fileEntity);
}
