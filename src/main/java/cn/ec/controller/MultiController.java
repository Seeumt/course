package cn.ec.controller;

import cn.ec.model.Department;
import cn.ec.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my")
public class MultiController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping(value = "/")
    public Department get(String departmentSn) {
        return departmentService.selectDepartmentBySn(departmentSn);

    }
}
