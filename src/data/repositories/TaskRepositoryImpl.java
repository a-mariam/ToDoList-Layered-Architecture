package data.repositories;

import data.models.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository{
private ArrayList<Task> taskList = new ArrayList<>();
private ArrayList<Task> urgentTasks = new ArrayList<>();
    @Override
    public Task save(Task task) {
     if(task.getId() == 0) {
         taskList.add(task);
         generateId(task);
     }else {
         int set = taskList.indexOf(findUserById(task.getId()));
         taskList.set(set, task);
     }
    return task;
    }

    private void generateId(Task task) {
     task.setId(taskList.size());
    }

    @Override
    public int numberOfTasks() {
        return taskList.size();
    }

    @Override
    public Task findUserById(int id) {
        for (Task tasks: taskList){
            if (tasks.getId() == id){
                return tasks;
            }
        }
        return null;
    }

    @Override
    public void deleteTaskById(int id) {
    taskList.remove(findUserById(id));
    }

    @Override
    public List<Task> findAll() {
        return taskList;
    }

    @Override
    public Task addToUrgentList(Task task) {
        urgentTasks.add(task);
        return task;
    }

    @Override
    public void removeFromUrgentList(Task task) {
    urgentTasks.remove(task);
    }

    @Override
    public ArrayList<Task> findAll_UrgentTasks() {
        return urgentTasks;
    }
}
