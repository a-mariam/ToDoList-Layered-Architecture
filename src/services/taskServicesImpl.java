package services;

import data.models.Task;
import data.repositories.TaskRepository;
import data.repositories.TaskRepositoryImpl;
import dto.responses.createUrgentTaskResponse;
import dto.requests.createTaskRequest;
import dto.responses.removeUrgentTaskFromUrgentListResponse;

import java.util.List;

public class taskServicesImpl implements TaskServices {

    private TaskRepository taskRepository = new TaskRepositoryImpl();

    private Task task;

    @Override
    public Task createTask(createTaskRequest createTaskRequest) {
        task = new Task();
        task.setName(createTaskRequest.getTitle());
        task.setBody(createTaskRequest.getBody());
        if (createTaskRequest.getIsUrgent().equalsIgnoreCase("yes")) {
            task.setUrgent(true);
        } else if (createTaskRequest.getIsUrgent().equalsIgnoreCase("no")) {
            task.setUrgent(false);
        }
        taskRepository.save(task);
        return task;
    }

    @Override
    public int getTaskSize() {
        return taskRepository.numberOfTasks();
    }

    @Override
    public void deleteTask(String taskTitle) {
     taskRepository.findAll().remove(findTaskByTitle(taskTitle));
    }

    @Override
    public List<Task> viewAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public createUrgentTaskResponse addTaskToUrgentList(Task task) {
        taskRepository.addToUrgentList(task);
        return null;
    }

    @Override
    public removeUrgentTaskFromUrgentListResponse removeFromUrgentList(Task removeTaskFromUrgentList) {
        return null;
    }


    @Override
    public Task findTaskByTitle(String taskTitle) {
        for (Task task1 : taskRepository.findAll()) {
            if(task1.getName() == taskTitle){
                return task1;
            }
        }
     throw new NullPointerException("Task does not exist");
    }

    @Override
    public List<Task> findAll_UrgentTasks() {
        return taskRepository.findAll_UrgentTasks();
    }
}