package cn.ec.dao;

import cn.ec.pojo.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface StudentMapper extends BaseMapper<Student> {

   IPage<Student> queryAll(Page page);

   Student getByName(String name);

   void saveStudent(Student student);

   int deleteStudent(Integer id);

   void updateStudent(Student student);
}
