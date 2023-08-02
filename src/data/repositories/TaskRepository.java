package data.repositories;

import data.models.Task;

import java.util.ArrayList;
import java.util.List;

public interface TaskRepository {

    Task save(Task task);

    int numberOfTasks();

    Task findUserById(int id);

    void deleteTaskById(int id);

    List<Task> findAll();
    Task addToUrgentList(Task task);
    void removeFromUrgentList(Task task);
    ArrayList<Task> findAll_UrgentTasks();
}
