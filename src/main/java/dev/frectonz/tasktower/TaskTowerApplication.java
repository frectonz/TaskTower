package dev.frectonz.tasktower;

import dev.frectonz.tasktower.config.RsaKeyProperties;
import dev.frectonz.tasktower.models.Project;
import dev.frectonz.tasktower.models.User;
import dev.frectonz.tasktower.repository.ProjectRepository;
import dev.frectonz.tasktower.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
@EnableConfigurationProperties(RsaKeyProperties.class)
public class TaskTowerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskTowerApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProjectRepository projects, PasswordEncoder encoder, UserRepository users) {
        return args -> {
            users.deleteAll();
            projects.deleteAll();

            User user = new User("frectonz", encoder.encode("password"));
            users.save(user);
            projects.save(new Project("Project 1", "Description 1", user));
        };
    }
}
