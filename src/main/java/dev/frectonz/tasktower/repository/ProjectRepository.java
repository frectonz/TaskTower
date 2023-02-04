package dev.frectonz.tasktower.repository;

import dev.frectonz.tasktower.models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface ProjectRepository extends MongoRepository<Project, String> {
}
