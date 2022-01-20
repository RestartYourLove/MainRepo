package lv.restart.your.love.Final.Project.Restart.Your.Love.repository;

import lv.restart.your.love.Final.Project.Restart.Your.Love.model.Task;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TaskRepository.java class is created by extending the JpaRepository interface.
 * JpaRepository interface is a Spring Data interface and provides all the CRUD operations automatically.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findById(long id);
    List<Task> findAll();


    //METHOD TO UPDATE task as done
    //METHOD TO UPDATE task as not done

}
