package dev.frectonz.tasktower.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

public class Project {
    @Id
    private String id;
    private String name;
    private String description;
    @DocumentReference
    private User owner;
    @DocumentReference
    private List<Task> tasks;

    public Project() {
    }

    public Project(String name, String description, User owner, List<Task> tasks) {
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", owner=" + owner +
                ", tasks=" + tasks +
                '}';
    }
}
