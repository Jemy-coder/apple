package com.jemy.apple.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author JEMY
 * @date 2020/06/11 : 21:11
 **/
public interface IOssService {

    String uploadFile(MultipartFile file);
}
