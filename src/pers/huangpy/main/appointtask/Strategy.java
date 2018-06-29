package pers.huangpy.main.appointtask;

import java.util.List;

public abstract class Strategy {

    protected String strategyName;

    abstract void appointTask(List<ServerDTO> servers, TaskDTO task);

    public final void execStrategy(List<ServerDTO> servers, TaskDTO task){
        appointTask(servers, task);
    }

    public String getStrategyName(){
        return strategyName;
    }

    protected void doAddList(ServerDTO server, TaskDTO task){
        server.setTaskSum(server.getTaskSum() + 1);
        server.getTaskIdList().add(task.getTaskId());
        task.setIpAddress(server.getIpAddress());
        System.out.println("成功将任务: " + task.getTaskId() + "分配给IP地址为: " + server.getIpAddress() + "的服务");
    }
}
