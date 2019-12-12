package cn.ec.dao;

import cn.ec.pojo.Student;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;
    @Test
    public void queryAll() {
        Page<Student> studentPage = new Page<>();
        studentPage.setCurrent(0);
        studentPage.setSize(2);
        String s = studentMapper.queryAll(studentPage).getRecords().toString();

    }
}
