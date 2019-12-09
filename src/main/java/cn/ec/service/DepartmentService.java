package cn.ec.service;

import cn.ec.model.Department;

public interface DepartmentService {

    Department selectDepartmentBySn(String departmentSn);
}
