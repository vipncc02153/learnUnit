package pers.huangpy.main.appointtask;

import java.util.List;
import java.util.Random;

public class RandomTask extends Strategy {

    public RandomTask(){
        this.strategyName = "RandomTask";
    }

    @Override
    public void appointTask(List<ServerDTO> servers, TaskDTO task) {
        Random random = new Random();
        doAddList(servers.get(random.nextInt(servers.size())),task);
    }
}
