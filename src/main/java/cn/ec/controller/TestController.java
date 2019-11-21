package cn.ec.controller;

import cn.ec.pojo.Builder;
import cn.ec.pojo.Person;
import cn.ec.pojo.Student;
import cn.ec.pojo.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
    public @ResponseBody Person c12(HttpServletRequest req ,@RequestBody(required = false) Person person) {
        System.out.println(person);
        return person;
    }

    @RequestMapping(value = "/c13", method = RequestMethod.POST, consumes = "application/json")
    public void c13(HttpEntity<Builder> b) {
        Builder body = b.getBody();

        System.out.println(body);
    }

    @RequestMapping(value = "/c14", method = RequestMethod.POST, consumes = "application/json")
    public void c14(HttpServletRequest req, @RequestBody Builder builder) {
        System.out.println(builder);

    }

    @RequestMapping(value = "/c15", method = RequestMethod.POST, consumes = "application/json")
    public void c15(@RequestBody Builder builder) {
        System.out.println(builder);
    }

//    @ModelAttribute("b")
//    public Builder c16() {
//        Builder builder = new Builder();
//        builder.setId(6);
//        builder.setName("hhhh");
//        return builder;
//    }

//    //无返回值
//    @ModelAttribute("b")
//    public void c160(Model model) {
//        Builder builder = new Builder();
//        builder.setId(8);
//        builder.setName("xxxxx");
//        model.addAttribute("bui", builder);
//    }
//
//    @ModelAttribute("b")
//    @RequestMapping("ok")
//    public void c1600(Model model) {
//        Builder builder = new Builder();
//        builder.setId(8);
//        builder.setName("xxxxx");
//        model.addAttribute("bui", builder);
//    }


    @RequestMapping(value = "/c17")
    public String c17(Model model) {
        System.out.println(model.toString());
        return "ok";
    }

    @RequestMapping(value = "/c18")
    public String c18() {
        return "ok";
    }

    @RequestMapping(value = "/c19")

    public @ResponseBody Builder c19(@Valid Builder builder, BindingResult result) {
        System.out.println(result);
        return builder;
    }

    @RequestMapping(value = "/c20", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Object getList() {
        List<Builder> list = new ArrayList<>();
        list.add(new Builder(6, null));
        return list;
    }

    @RequestMapping(value = "/c21", method = RequestMethod.POST, consumes = "application/xxx-custom")
    public @ResponseBody User converter(@RequestBody User user) {
        return user;
    }

}
