package cn.ec.dao;

import cn.ec.pojo.Student;

public interface StudentMapper {
   Student getByName(String name);

   void saveStudent(Student student);

   int deleteStudent(Integer id);

   void updateStudent(Student student);
}
