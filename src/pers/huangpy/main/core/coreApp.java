package pers.huangpy.main.core;

import pers.huangpy.main.appointtask.TaskUnit;
import pers.huangpy.main.util.HumpUtil;

public class coreApp {
    public static void main(String[] args){
        //BeanToJsonUnit.beanToJsonUnit();
        TaskUnit taskUnit = new TaskUnit();
        taskUnit.taskUnit();
        //HumpUtil.toCamel();
        HumpUtil.maintest5();
        //System.out.println(strategies.get(0).getStrategyName());
    }
}
