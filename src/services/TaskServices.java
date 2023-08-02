package services;

import data.models.Task;
import dto.requests.createTaskRequest;
import dto.responses.removeUrgentTaskFromUrgentListResponse;
import dto.responses.createUrgentTaskResponse;

import java.util.List;

public interface TaskServices {

    Task createTask(createTaskRequest createTaskRequest);

    int getTaskSize();
    void deleteTask(String taskTitle);
    List<Task> viewAllTask();
    createUrgentTaskResponse addTaskToUrgentList(Task task);
   removeUrgentTaskFromUrgentListResponse removeFromUrgentList(Task removeTaskFromUrgentList);
   Task findTaskByTitle(String taskTitle);
   List<Task> findAll_UrgentTasks();
}
