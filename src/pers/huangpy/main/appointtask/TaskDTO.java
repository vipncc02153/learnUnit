package pers.huangpy.main.appointtask;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class TaskDTO {
    private Long taskId;
    private String ipAddress;
    private BigDecimal amount;
    private Timestamp createTime;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

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
