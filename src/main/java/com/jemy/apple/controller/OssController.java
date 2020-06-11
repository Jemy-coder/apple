package com.jemy.apple.controller;

import com.jemy.apple.service.IOssService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author JEMY
 * @date 2020/06/11 : 21:09
 **/
@RestController
@RequestMapping("/oss")
public class OssController {

    @Resource
    private IOssService iOssService;

    @PostMapping
    public String uploadFile(MultipartFile file){
        return iOssService.uploadFile(file);
    }
}
