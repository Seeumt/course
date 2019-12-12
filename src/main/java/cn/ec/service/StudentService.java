package cn.ec.service;

import cn.ec.pojo.Student;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface StudentService {
    Student getByName(String name);
    void save(Student student);
    int update(Student student);
    int delete(Integer name);
    IPage<Student> queryAll(Integer current,Integer size);

    List<Student> findAll();
}
