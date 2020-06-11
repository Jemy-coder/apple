package com.jemy.apple.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.jemy.apple.service.IOssService;
import com.jemy.apple.util.Constant;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author JEMY
 * @date 2020/06/11 : 21:11
 **/
@Service
public class OssServiceImpl implements IOssService {

    @Override
    public String uploadFile(MultipartFile file) {

        String endpoint = Constant.ENDPOINT;
        String accessKeyId = Constant.ACCESS_KEY_ID;
        String accessKeySecret = Constant.ACCESS_KEY_SECRET;

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            InputStream inputStream = file.getInputStream();
            String name = file.getOriginalFilename();

            ossClient.putObject(Constant.BUCKET_NAME, name, inputStream);

            ossClient.shutdown();
            //https://jemy-apple.oss-cn-shenzhen.aliyuncs.com/2.jpg
            return "https://"+Constant.BUCKET_NAME+"."+Constant.ENDPOINT+"/"+name;
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
