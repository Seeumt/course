package cn.ec.controller;

import cn.ec.pojo.Student;
import cn.ec.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/students")
@Slf4j
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/get")
    @ResponseBody
    public Student getByName(String name) {
        Student student = studentService.getByName(name);
        log.trace("This is trace");
        log.info("This is info");
        log.warn("This is warn");
        log.debug("This is debug");
        log.error("This is error");
        return student;
    }


}
