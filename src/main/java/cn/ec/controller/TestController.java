package cn.ec.controller;

import cn.ec.pojo.Builder;
import cn.ec.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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

    @RequestMapping( {"/test"} )
    @ResponseBody
    public Builder test(Locale local) {
        Builder builder = new Builder();
        builder.setId(1);
        builder.setName("XCMG");
        System.out.println(local.getCountry());
        System.out.println(local.getLanguage());
        return builder;
    }
    @RequestMapping( "/c1" )
    @ResponseBody
    public Builder c1(HttpServletRequest request) {
        String method = request.getMethod();
        System.out.println(method);
        Builder builder = new Builder();
        builder.setId(1);
        builder.setName("XCMG");
        return builder;
    }

    @RequestMapping( "/c2" )
    public String c2(Model model,HttpServletRequest request,Builder builder) {

        request.setAttribute("msg","成功啦！！");
        request.setAttribute("builder",builder);
        System.out.println(builder);
        return "ok";
    }

    @RequestMapping( "/c3" )
    @ResponseBody
    public Builder c3(Integer id ,@RequestParam(name = "username",required = true,defaultValue = "XCMG001") String name) {
        Builder builder = new Builder();
        builder.setId(id);
        builder.setName(name);
        return builder;
    }

    @RequestMapping("/c4/{id}/{name}")
    public ModelAndView c4(ModelAndView mv,@PathVariable Integer id, @PathVariable String name){

        mv.addObject("id",id);
        mv.addObject("name",name);
        mv.setViewName("ok");
        return mv;
    }

    @GetMapping("/c5/{id}/{name}")
    @ResponseBody
    public Builder c5(@PathVariable Integer id, @PathVariable String name){
        Builder builder = new Builder();
        builder.setId(id);
        builder.setName(name);
        return builder;
    }


}
