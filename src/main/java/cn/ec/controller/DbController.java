package cn.ec.controller;

import cn.ec.model.User;
import cn.ec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
/**
 * @author rx
 */
public class DbController {

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

    @GetMapping(value = "/05",produces = MediaType.APPLICATION_JSON_VALUE)
    public User selectByIdAndPid(Integer id, Integer pid) {
        return userService.selectByIdAndPid(id, pid);
    }

    @GetMapping(value = "/06",produces = MediaType.APPLICATION_JSON_VALUE)
    public User query(Integer id, Integer pid) {
        Map<String,Object> map = new HashMap<>(100);
        map.put("id", id);
        map.put("pid", pid);
        return userService.query(map);
    }

    @GetMapping(value = "/07",produces = MediaType.APPLICATION_JSON_VALUE)
    public User queryByUser(User user) {
        return userService.queryByUser(user);
    }


    @GetMapping(value = "/08",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> queryByIds(@RequestParam("ids") List<Integer> ids) {
        return userService.queryByIds(ids);
    }

    @PostMapping(value = "/0801",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> queryByIds01(cn.ec.dto.User user) {
        return userService.queryByUserIds(user);
    }

    @GetMapping(value = "/09",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> queryByIds(@RequestBody cn.ec.dto.User user) {
        return userService.queryByIds(user.getIds());
    }

    @GetMapping(value = "/10", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> queryByArrayIds(@RequestParam("ids") Integer[] ids) {
        return userService.queryByArrayIds(ids);
    }




}
