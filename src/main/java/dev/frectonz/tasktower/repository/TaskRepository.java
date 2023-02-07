package dev.frectonz.tasktower.repository;

import dev.frectonz.tasktower.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
