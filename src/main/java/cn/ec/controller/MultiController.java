package cn.ec.controller;

import cn.ec.dao.RoleMapper;
import cn.ec.model.Department;
import cn.ec.model.User;
import cn.ec.pojo.Params;
import cn.ec.service.DepartmentService;
import cn.ec.service.RoleService;
import cn.ec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/my")
public class MultiController {
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private RoleService roleService;
    @GetMapping(value = "/")
    public Department get(String departmentSn) {
        return departmentService.selectDepartmentBySn(departmentSn);
    }


    @GetMapping(value = "/proc",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> proc() {
        Params params = new Params();
        return userService.selectByDepartmentSn(params);

    }


    @GetMapping(value = "/procMap",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> procMap(String departmentSn,Integer count) {
        Map<String,Object> map = new HashMap<>();
        map.put("departmentSn", departmentSn);
        map.put("count", count);
        return userService.selectByDepartmentSnOfMap(map);

    }

    @GetMapping(value = "/insert",produces = MediaType.APPLICATION_JSON_VALUE)
    public void insert() {

        roleService.insert();
    }






}
