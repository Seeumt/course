package cn.ec.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

//@Data
//@Component
//@ConfigurationProperties(prefix = "student")
//@PropertySource("classpath:student.properties")
@Data
public class Student {

    private Integer id;

    public String name;

    public Integer age;

    public Student(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
