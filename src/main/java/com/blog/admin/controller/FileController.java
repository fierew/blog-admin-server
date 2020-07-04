package com.blog.admin.controller;

import com.blog.admin.entity.FileEntity;
import com.blog.admin.entity.Result;
import com.blog.admin.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyang
 */
@Slf4j
@RestController
public class FileController {

    private FileService fileService;

    @Autowired
    public void setFileService(FileService fileService){
        this.fileService = fileService;
    }

    @PostMapping("file/checkFile")
    Result checkFile(String hash){
        Result result = new Result();
        result.setData(fileService.checkFile(hash));
        result.setCode(200);
        result.setMsg("success");

        return result;
    }

    @PostMapping("file/upload")
    Result upload(FileEntity fileEntity){
        fileService.upload(fileEntity);
        return new Result();
    }
}
