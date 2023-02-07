package dev.frectonz.tasktower;

import dev.frectonz.tasktower.config.RsaKeyProperties;
import dev.frectonz.tasktower.models.Project;
import dev.frectonz.tasktower.models.Task;
import dev.frectonz.tasktower.models.User;
import dev.frectonz.tasktower.repository.ProjectRepository;
import dev.frectonz.tasktower.repository.TaskRepository;
import dev.frectonz.tasktower.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
@EnableConfigurationProperties(RsaKeyProperties.class)
public class TaskTowerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskTowerApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            PasswordEncoder encoder,
            UserRepository users,
            TaskRepository tasks,
            ProjectRepository projects
    ) {
        return args -> {
            users.deleteAll();
            tasks.deleteAll();
            projects.deleteAll();

            User user = new User("frectonz", encoder.encode("password"));

            Task task = new Task("Task 1", false, user);
            Project project = new Project("Project 1", "Description 1", user, List.of(task));

            users.save(user);
            tasks.save(task);
            projects.save(project);
        };
    }
}
