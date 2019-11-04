package cn.ec.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "student")
@PropertySource("classpath:student.properties")
public class Student {

    private String name;

    private Integer age;

}
