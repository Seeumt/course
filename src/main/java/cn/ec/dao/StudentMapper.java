package cn.ec.dao;

import cn.ec.pojo.Student;

public interface StudentMapper {
   Student getByName(String name);
}
