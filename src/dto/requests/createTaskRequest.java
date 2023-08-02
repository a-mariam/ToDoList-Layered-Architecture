package dto.requests;

public class createTaskRequest {
    private String title;
    private  String body;
    private String isUrgent;
    private String taskDeadLine;
    private String deadLine;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTaskDeadLine() {
        return taskDeadLine;
    }

    public void setTaskDeadLine(String taskDeadLine) {
        this.taskDeadLine = taskDeadLine;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setIsUrgent(String status) {
        this.isUrgent = status;
    }
    public String getIsUrgent(){
        return isUrgent;
    }
    public void setDeadLine(String s) {
    }
}
