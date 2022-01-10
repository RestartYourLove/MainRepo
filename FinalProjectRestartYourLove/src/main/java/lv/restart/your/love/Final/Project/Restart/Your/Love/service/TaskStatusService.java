package lv.restart.your.love.Final.Project.Restart.Your.Love.service;

import lv.restart.your.love.Final.Project.Restart.Your.Love.model.TaskStatus;
import lv.restart.your.love.Final.Project.Restart.Your.Love.repository.TaskStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskStatusService {

    @Autowired
    TaskStatusRepository taskStatusRepository;

    public TaskStatus findById(long id) {
        return taskStatusRepository.findById(id);
    }


    public List<TaskStatus> findAll() {
        return taskStatusRepository.findAll();
    }

}
