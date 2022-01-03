package lv.restart.your.love.Final.Project.Restart.Your.Love.repository;

import lv.restart.your.love.Final.Project.Restart.Your.Love.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

    Task findById(int id);
    List<Task> findAll();
    void deleteById(int id);
}
