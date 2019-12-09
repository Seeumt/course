package cn.ec.dao;

import cn.ec.model.Department;

public interface DepartmentMapper {
    Department selectDepartmentBySn(String departmentSn);
}
