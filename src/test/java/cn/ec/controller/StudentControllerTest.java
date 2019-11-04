package cn.ec.controller;

import cn.ec.config.RoomConfig;
import cn.ec.pojo.Language;
import cn.ec.pojo.Room;
import cn.ec.pojo.Student;
import cn.ec.service.RoomService;
import org.apache.ibatis.annotations.Lang;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)

public class StudentControllerTest {


    @Autowired
    private Student student;
    @Autowired
    private Room room;
    @Autowired
    private RoomService roomService;
    @Test
    public void testRoom() {
        System.out.println(room);
        System.out.println(room.getArea());
        roomService.say();
        System.out.println(student);
    }


}
