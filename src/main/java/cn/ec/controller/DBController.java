package cn.ec.controller;

import cn.ec.model.User;
import cn.ec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class DBController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserService userService;
    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> getByName() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from student");
        return list.get(0);
    }

    @GetMapping(value = "/01",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Map<String, Object>> getList() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from student");
        return list;
    }

    @GetMapping(value = "/02",produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserId(Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping(value = "/03",produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<User> findById(Integer id) {
        return userService.findById(id);
    }

    @GetMapping(value = "/04",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> findOne(String userSn) {
        return userService.findOne(userSn);
    }

}
