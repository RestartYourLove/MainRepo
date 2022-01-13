package lv.restart.your.love.Final.Project.Restart.Your.Love.repository;

import lv.restart.your.love.Final.Project.Restart.Your.Love.model.Task;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.TaskStatus;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.TaskStatusKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskStatusRepository extends JpaRepository<TaskStatus, TaskStatusKey> {

    TaskStatus findById(long id);
    List<TaskStatus> findAll();


}
