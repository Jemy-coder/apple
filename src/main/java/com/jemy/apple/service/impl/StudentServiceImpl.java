package com.jemy.apple.service.impl;

import com.jemy.apple.entity.Student;
import com.jemy.apple.mapper.StudentMapper;
import com.jemy.apple.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jemy
 * @since 2020-06-04
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
