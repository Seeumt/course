package cn.ec.service;

import cn.ec.pojo.Student;

public interface StudentService {
    Student getByName(String name);
    void save(Student student);
    int update(Student student);
}
