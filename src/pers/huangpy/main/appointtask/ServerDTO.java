package pers.huangpy.main.appointtask;

import java.util.ArrayList;
import java.util.List;

/**
 * <ul>
 *     <li>ipAddress:服务器IP地址</li>
 *     <li>appointFlag:</li>
 * </ul>
 */
public class ServerDTO {
    private String ipAddress;
    private Integer taskSum;
    private List<Long> taskIdList;

    public ServerDTO(){
        ipAddress = "";
        taskSum = 0;
        List<Long> taskIdList = new ArrayList<>();
        this.taskIdList = taskIdList;
    }

    public ServerDTO(String ipAddress){
        this.ipAddress = ipAddress;
        taskSum = 0;
        List<Long> taskIdList = new ArrayList<>();
        this.taskIdList = taskIdList;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getTaskSum() {
        return taskSum;
    }

    public void setTaskSum(Integer taskSum) {
        this.taskSum = taskSum;
    }

    public List<Long> getTaskIdList() {
        return taskIdList;
    }

    public void setTaskIdList(List<Long> taskIdList) {
        this.taskIdList = taskIdList;
    }

    @Override
    public String toString() {
        return "ServerDTO{" +
                "ipAddress='" + ipAddress + '\'' +
                ", taskSum=" + taskSum +
                ", taskIdList=" + taskIdList +
                '}';
    }
}
