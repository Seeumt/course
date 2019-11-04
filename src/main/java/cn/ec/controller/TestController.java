package cn.ec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping( {"/success"} )
    public String success(Map<String, Object> map) {
        map.put("msg", "成功啦");
        //classpath:/templates/success.html
        return "success";
    }

}
