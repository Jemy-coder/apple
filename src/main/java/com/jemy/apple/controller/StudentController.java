package com.jemy.apple.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jemy.apple.entity.Student;
import com.jemy.apple.service.IStudentService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jemy
 * @since 2020-06-04
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    private static final Logger log = LogManager.getLogger();

    @Resource
    private IStudentService studentService;


    @ApiOperation("新增学生信息")
    @PostMapping( value = "creat")
    public String creat(@RequestBody Student student){

        studentService.save(student);

        log.info("Add" + student + "success.");

        return "OK";
    }

    @ApiOperation("删除学生信息")
    @DeleteMapping( value = "{user_id}/delete")
    public String delete(@PathVariable("user_id") int id){

        studentService.removeById(id);

        return "OK";
    }

    @ApiOperation("更新学生信息")
    @PutMapping( value = "{user_id}/update")
    public String update(@PathVariable("user_id") int id,@RequestBody Student student){

        UpdateWrapper<Student> updateWrapper = new UpdateWrapper();
        updateWrapper.eq("id",id);

        boolean update = studentService.update(student, updateWrapper);

        if (update){
            return "OK";
        }else {
            return "Fail";
        }


    }

    @ApiOperation("查询学生信息")
    @GetMapping( value = "list")
    public List<Student> list(){
        return studentService.list();
    }

}
