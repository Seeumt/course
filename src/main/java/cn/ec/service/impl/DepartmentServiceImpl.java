package cn.ec.service.impl;

import cn.ec.dao.DepartmentMapper;
import cn.ec.model.Department;
import cn.ec.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public Department selectDepartmentBySn(String departmentSn) {
        return departmentMapper.selectDepartmentBySn(departmentSn);
    }

}
