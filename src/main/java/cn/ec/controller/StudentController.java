package cn.ec.controller;
import cn.ec.pojo.Student;
import cn.ec.service.StudentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(value = "/students",method= RequestMethod.GET)
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/get",
            consumes = "application/json",
            produces = MediaType.APPLICATION_JSON_VALUE,
            params={"my=hi","msg=666"},
            headers = "myh=head")
    @ResponseBody
    public Student getByName(String name) {
        Student student = studentService.getByName(name);
        log.trace("This is trace");
        log.info("This is info");
        log.warn("This is warn");
        log.debug("This is debug");
        log.error("This is err" +
                "" +
                "or");
        if (student == null) {
            throw new RuntimeException("没找到哦");
        }
        return student;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Student> findAll() {
        List<Student> all = studentService.findAll();
        return all;

    }

    @GetMapping(value = "/page",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Student> page(Integer current,Integer size) {
        IPage<Student> studentIPage = studentService.queryAll(current, size);
        List<Student> records = studentIPage.getRecords();
        return records;

    }


}
