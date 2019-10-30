package cn.ec.controller;

import cn.ec.pojo.Language;
import org.apache.ibatis.annotations.Lang;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentControllerTest {
    @Value("${name}")
    private String name;
    @Value("${age}")
    private Integer age;
    @Value("${fruits}")
    private int[] fruits;
    @Value("${valueList}")
    private List list;
    @Value("${valueMapList}")
    private List<Map> mapList;
    @Autowired
    private Language language;
    @Test
    public void getByName() {
        System.out.println(name);
        System.out.println(age);
//        for (int fruit : fruits) {
//            System.out.println(fruit);
//        } 循环遍历fruits 这个是for-each循环

    }

    @Test
    public void getByName2() {
        System.out.println(language.getName());
        System.out.println(language.getLevel());
    }
}
