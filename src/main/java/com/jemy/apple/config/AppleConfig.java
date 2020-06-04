package com.jemy.apple.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author JEMY
 * @date 2020/06/04 : 21:24
 **/
@Configuration
@MapperScan("com.jemy.apple.mapper")
public class AppleConfig {
}
