package cn.ec.controller;

import cn.ec.pojo.Builder;
import cn.ec.pojo.Room;
import cn.ec.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("/test")
public class TestController {
    @RequestMapping( {"/success"} )
    public String success(Map<String, Object> map) {
        map.put("msg", "成功啦");
        //classpath:/templates/success.html
        return "success";
    }

    @GetMapping("/ok")
    public String success(Model model) {
        model.addAttribute("test", "要成功呀");
        return "ok";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List list = new ArrayList<>();
        list.add(new Student("s1", 10));
        list.add(new Student("s2", 20));
        model.addAttribute("list", list);
        return "success";
    }




}
