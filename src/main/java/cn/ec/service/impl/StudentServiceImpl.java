package cn.ec.service.impl;

import cn.ec.dao.StudentMapper;
import cn.ec.pojo.Student;
import cn.ec.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Student getByName(String name) {
//        int a = 5 / 0;
        return studentMapper.getByName(name);
    }

    public void save(Student student) {
        System.out.println("save");
    }

    @Override
    public int update(Student student) {
        System.out.println("update");
        return 0;
    }


}
