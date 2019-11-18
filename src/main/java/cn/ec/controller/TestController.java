package cn.ec.controller;

import cn.ec.pojo.Builder;
import cn.ec.pojo.Person;
import cn.ec.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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

    @GetMapping("/c6/{id}/{name}")
    @ResponseBody
    public Builder c6(@PathVariable Integer id, @PathVariable String name,
                      @MatrixVariable(name = "num",pathVar = "id") Integer[] num,
                      @MatrixVariable(name = "date",pathVar = "id") Integer date){
        Builder builder = new Builder();
        builder.setId(id);
        builder.setName(name);
        System.out.println(num);
        for (Integer item : num) {
            System.out.println(item);
        }
        return builder;
    }

    @GetMapping("/c7/{id}/{name}")
    @ResponseBody
    public Builder c7(@PathVariable Integer id, @PathVariable String name,
                      @MatrixVariable(name = "num",pathVar = "name") Integer num,
                      @MatrixVariable(name = "date",pathVar = "name") Integer date){
        Builder builder = new Builder();
        builder.setId(id);
        builder.setName(name);
        System.out.println(num);
        System.out.println(date);
        return builder;
    }

    @PostMapping("/c8")
    public String c8(@RequestPart("file") MultipartFile file) {
            String filePath = "C:\\" + file.getOriginalFilename();
        try {
            file.transferTo(new File(filePath));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return "ok";
    }

    @RequestMapping("/c9")
    public String c9(@RequestPart("file") MultipartFile[] files) {
        for(MultipartFile file : files){
            String filePath = "C:\\" + file.getOriginalFilename();
            try {
                file.transferTo(new File(filePath));
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
        return "ok";
    }

    @RequestMapping("/c10")
    public String c10(@CookieValue("JSESSIONID") String sessionId) {
        System.out.println(sessionId);
        return "ok";
    }

    @RequestMapping(value = "/c11", method = RequestMethod.POST, consumes="application/json")
    public String c11(HttpServletRequest req ,@RequestBody(required = false) Builder builder) {
        System.out.println(builder);
        return "ok";
    }

    @RequestMapping(value = "/c12", method = RequestMethod.POST, consumes="application/xml")
    public void c12(HttpServletRequest req ,@RequestBody(required = false) Person person) {
        System.out.println(person);
    }



}
