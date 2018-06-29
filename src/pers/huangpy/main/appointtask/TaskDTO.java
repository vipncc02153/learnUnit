package pers.huangpy.main.appointtask;

public class TaskDTO {
    private Long taskId;
    private String ipAddress;

    public TaskDTO(){};

    public TaskDTO(Long taskId){
        this.taskId = taskId;
        ipAddress = "";
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "taskId=" + taskId +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
