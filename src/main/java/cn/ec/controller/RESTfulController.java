package cn.ec.controller;

import cn.ec.pojo.Student;
import cn.ec.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@Slf4j
public class RESTfulController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getByName(@RequestParam("name") String name) {

        try {
            Student student = studentService.getByName(name);
            if (student == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
                return ResponseEntity.ok(student);
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

    }

    @PostMapping(value = "/")
    public ResponseEntity<Void> save(@RequestBody Student student) {

        try {
             studentService.save(student);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

    }


    @PutMapping(value = "/")
    public ResponseEntity<Void> update(@RequestBody Student student) {

        try {
            int count = studentService.update(student);

                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

    }
}
