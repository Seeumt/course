package cn.ec.controller;

import cn.ec.model.Class;
import cn.ec.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping("/my")
public class MyController {
    @Autowired
    private ClassService classService;
    @GetMapping(value = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public Class findClassesWithTeacher(Integer cid) {
      return classService.findClassesWithTeacher(cid);
    }
}
