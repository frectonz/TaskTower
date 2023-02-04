package dev.frectonz.tasktower;

import dev.frectonz.tasktower.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class TaskTowerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskTowerApplication.class, args);
    }

}
