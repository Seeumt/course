package cn.ec;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@MapperScan("cn.ec.dao")
public class CourseApplication {

    public static void main(String[] args) {

        SpringApplication.run(CourseApplication.class, args);
    }

}
