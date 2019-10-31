package cn.ec.config;

import cn.ec.pojo.Room;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@ImportResource(locations = {"classpath:spring01.xml"})
@Component
public class RoomConfig {
    @Bean
    @ConfigurationProperties(prefix = "room")
    public Room room() {
        return new Room();
    }
}
