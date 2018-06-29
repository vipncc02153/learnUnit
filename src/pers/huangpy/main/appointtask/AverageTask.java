package pers.huangpy.main.appointtask;


import java.util.List;

public class AverageTask extends Strategy{

    public AverageTask(){
        strategyName = "AverageTask";
    }

    @Override
    public void appointTask(List<ServerDTO> servers, TaskDTO task){
        Integer minIndex = 0;
        Integer minSum = 9999;
        for(int i = 0; i < servers.size(); i++){
            if(minSum > servers.get(i).getTaskSum()){
                minIndex = i;
                minSum = servers.get(i).getTaskSum();
            }
        }
        doAddList(servers.get(minIndex),task);

    }
}
