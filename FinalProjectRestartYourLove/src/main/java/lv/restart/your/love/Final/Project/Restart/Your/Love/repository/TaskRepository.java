package lv.restart.your.love.Final.Project.Restart.Your.Love.repository;

import lv.restart.your.love.Final.Project.Restart.Your.Love.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findById(long id);
    List<Task> findAll();


    //METHOD TO UPDATE task as done
    //METHOD TO UPDATE task as not done

}
