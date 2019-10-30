package cn.ec.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "language")
@Data
public class Language {

    private String name;
    private String level;
}
