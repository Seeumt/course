package cn.ec.service.impl;

import cn.ec.dao.StudentMapper;
import cn.ec.pojo.Student;
import cn.ec.service.StudentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;
    @Override
    public Student getByName(String name) {
//        int a = 5 / 0;
        return studentMapper.getByName(name);
    }
    @Override
    public void save(Student student) {
        studentMapper.saveStudent(student);
    }

    @Override
    public int update(Student student) {
        studentMapper.updateStudent(student);
        return 0;
    }

    @Override
    public int delete(Integer id) {
        studentMapper.deleteStudent(id);
        return 0;
    }

    @Override
    public IPage<Student> queryAll(Integer current,Integer size) {
        Page<Student> studentPage = new Page<>();
        studentPage.setCurrent(current);
        studentPage.setSize(size);
        return studentMapper.queryAll(studentPage);
    }

    @Override
    public List<Student> findAll() {
        return studentMapper.selectList(null);
    }


}
