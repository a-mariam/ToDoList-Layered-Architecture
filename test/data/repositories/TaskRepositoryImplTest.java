package data.repositories;

import data.models.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskRepositoryImplTest {
    TaskRepository taskRepository = new TaskRepositoryImpl();
    @Test
    public void testThatTaskCanCreateTask(){
        Task task = new Task();
        taskRepository.save(task);
        assertEquals(1,taskRepository.numberOfTasks());
    }
    @Test
    public void testThat_TwoTask_IsCreated_TwoIs_Saved(){
        Task task = new Task();
        Task task1 = new Task();
        taskRepository.save(task);
        taskRepository.save(task1);
        assertEquals(2,taskRepository.numberOfTasks());
    }
    @Test
    public void testThat_Task_CanBe_Updated(){
        Task task = new Task();
        Task task1 = new Task();
        task1.setId(1);
        taskRepository.save(task);
        taskRepository.save(task1);
        assertEquals(1,taskRepository.numberOfTasks());
    }
    @Test
    public void testThat_Task_CanBe_FindBy_Id(){
      Task task = new Task();
      taskRepository.save(task);
      assertEquals(task,taskRepository.findUserById(1));
    }
    @Test
    public void testThat_Task_CanBe_Deleted_BYId(){
        Task task = new Task();
        taskRepository.save(task);
        taskRepository.deleteTaskById(1);
        assertEquals(0, taskRepository.numberOfTasks());
    }
    @Test
    public void testThat_WhenTask3_IsUpdated_ToTask1_TheId_Is1(){
        Task task = new Task();
        Task task1 = new Task();
        Task task2 = new Task();
        Task task3 = new Task();
        task3.setId(1);
        taskRepository.save(task);
        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);
        assertSame(1,task3.getId());
        assertSame(2,task1.getId());
    }

    @Test
    public void testThat_AllTask_CanBe_Found(){
        Task task = new Task();
        Task task1 = new Task();
        Task task2 = new Task();
        taskRepository.save(task);
        taskRepository.save(task1);
        taskRepository.save(task2);
        for (int index = 0; index < taskRepository.numberOfTasks(); index++){
            assertTrue(taskRepository.findAll().contains(task2));
            assertTrue(taskRepository.findAll().contains(task));
            assertTrue(taskRepository.findAll().contains(task1));
        }
    }
}