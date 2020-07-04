package com.blog.admin.service.impl;

import com.blog.admin.entity.FileEntity;
import com.blog.admin.model.FileModel;
import com.blog.admin.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


/**
 * @author xuyang
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {
    @Override
    public Boolean checkFile(String hash){
        // 判断sha256是否存在
        return true;
    }

    /**
     * 但文件上传
     * @param fileEntity 文件数据
     * @return
     */
    @Override
    public FileModel upload(FileEntity fileEntity){
        MultipartFile file = fileEntity.getFile();
        try{
            if(file.isEmpty()){
                return null;
            }

            String fileName = file.getOriginalFilename();
            assert fileName != null;
            String suffixName = fileName.substring(fileName.lastIndexOf("."));

            log.info("上传的文件名为：" + fileName + " 后缀名为：" + suffixName);

            // 设置文件存储路径
            String filePath = "upload/";
            String path = filePath + fileName;

            File dest = new File(path);

            // 检查是否存在路径目录
            if(!dest.getParentFile().exists()){

                // 新建目录
                dest.getParentFile().mkdirs();
            }

            file.transferTo(dest);

            // 写入文件成功，开始插入数据库
        }catch (IllegalStateException | IOException e){
            e.printStackTrace();
        }

        return new FileModel();
    }
}