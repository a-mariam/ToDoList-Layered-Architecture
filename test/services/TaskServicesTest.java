package services;

import dto.requests.createTaskRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServicesTest {
    TaskServices taskServices = new taskServicesImpl();
@Test
    public void testThat_ObjectExist(){
    assertNotNull(taskServices);
}
@Test
    public void testThat_TaskCanBe_Created(){
    createTaskRequest createTaskRequest = new createTaskRequest();
    createTaskRequest.setTitle("work to be done");
    createTaskRequest.setBody("I want to eat at 4 am");
    createTaskRequest.setIsUrgent("yes");
    createTaskRequest.setDeadLine("23-4-2023");
    taskServices.createTask(createTaskRequest);
    assertEquals(1,taskServices.getTaskSize());
}
    @Test
    public void testThat_TwoTaskCanBe_Created(){
        createTaskRequest createTaskRequest = new createTaskRequest();
        createTaskRequest.setTitle("work to be done");
        createTaskRequest.setBody("I want to eat at 4 am");
        createTaskRequest.setIsUrgent("yes");
        createTaskRequest.setDeadLine("23-4-2023");
        taskServices.createTask(createTaskRequest);
        createTaskRequest createTaskRequest2 = new createTaskRequest();
        createTaskRequest2.setTitle("works");
        createTaskRequest2.setBody("I want to eat");
        createTaskRequest2.setIsUrgent("no");
        createTaskRequest2.setDeadLine("23-4-2023");
        taskServices.createTask(createTaskRequest2);
        assertEquals(2,taskServices.getTaskSize());
    }

    @Test
    public void testThat_Task_CanBe_Deleted(){
        createTaskRequest createTaskRequest = new createTaskRequest();
        createTaskRequest.setTitle("work to be done");
        createTaskRequest.setBody("I want to eat at 4 am");
        createTaskRequest.setIsUrgent("yes");
        createTaskRequest.setDeadLine("23-4-2023");
        taskServices.createTask(createTaskRequest);
        taskServices.deleteTask("work to be done");
        assertEquals(0,taskServices.getTaskSize());
    }
    @Test
    public void testThat_DeleteTask_ByTitle_ThrowException_WhenWrong_TitleIs_Entered(){
        createTaskRequest createTaskRequest = new createTaskRequest();
        createTaskRequest.setTitle("work to be done");
        createTaskRequest.setBody("I want to eat at 4 am");
        createTaskRequest.setIsUrgent("yes");
        createTaskRequest.setDeadLine("23-4-2023");
        taskServices.createTask(createTaskRequest);
        assertThrows(NullPointerException.class,()->taskServices.deleteTask("work to be dones"));
        try{
            taskServices.deleteTask("work to be dones");
        }catch (NullPointerException ex){
            assertEquals(ex.getMessage() ,"Task does not exist");
            assertEquals(NullPointerException.class, ex.getClass());
        }
        taskServices.deleteTask("work to be done");
        assertEquals(0,taskServices.getTaskSize());
    }
    @Test
    public void testThat_AllTask_CanBe_FoundInTaskList(){
        createTaskRequest createTaskRequest = new createTaskRequest();
        createTaskRequest.setTitle("work to be done");
        createTaskRequest.setBody("I want to eat at 4 am");
        createTaskRequest.setIsUrgent("yes");
        createTaskRequest.setDeadLine("23-4-2023");
        taskServices.createTask(createTaskRequest);
        createTaskRequest createTaskRequest2 = new createTaskRequest();
        createTaskRequest2.setTitle("works");
        createTaskRequest2.setBody("I want to eat");
        createTaskRequest2.setIsUrgent("no");
        createTaskRequest2.setDeadLine("23-4-2023");
        taskServices.createTask(createTaskRequest2);
//        for (int count = 0; count < taskServices.getTaskSize(); count++){
//            assertTrue(taskServices.viewAllTask().contains(createTaskRequest));
//            assertTrue(taskServices.viewAllTask().contains(createTaskRequest2));
//        }
        assertEquals(2,taskServices.getTaskSize());
    }
    @Test
    public void testThat_Task_CanBe_AddedTo_UrgentList(){
        createTaskRequest createTaskRequest = new createTaskRequest();
        createTaskRequest.setTitle("work to be done");
        createTaskRequest.setBody("I want to eat at 4 am");
        createTaskRequest.setIsUrgent("yes");
        createTaskRequest.setDeadLine("23-4-2023");
        taskServices.createTask(createTaskRequest);
        taskServices.addTaskToUrgentList(taskServices.createTask(createTaskRequest));
        assertEquals(1, taskServices.findAll_UrgentTasks());
    }
    @Test
    public void testThat_AllUrgent_Task_CanBe_Found(){
            createTaskRequest createTaskRequest = new createTaskRequest();
            createTaskRequest.setTitle("work to be done");
            createTaskRequest.setBody("I want to eat at 4 am");
            createTaskRequest.setIsUrgent("yes");
            createTaskRequest.setDeadLine("23-4-2023");
            taskServices.createTask(createTaskRequest);
            createTaskRequest createTaskRequest2 = new createTaskRequest();
            createTaskRequest2.setTitle("works");
            createTaskRequest2.setBody("I want to eat");
            createTaskRequest2.setIsUrgent("no");
            createTaskRequest2.setDeadLine("23-4-2023");
            taskServices.createTask(createTaskRequest2);
        taskServices.addTaskToUrgentList(taskServices.createTask(createTaskRequest));
        taskServices.addTaskToUrgentList(taskServices.createTask(createTaskRequest2));
            for (int count = 0; count < taskServices.findAll_UrgentTasks().size(); count++){
                assertTrue(taskServices.findAll_UrgentTasks().contains(taskServices.createTask(createTaskRequest)));
                assertTrue(taskServices.findAll_UrgentTasks().contains(taskServices.createTask(createTaskRequest2)));

            }
    }
}