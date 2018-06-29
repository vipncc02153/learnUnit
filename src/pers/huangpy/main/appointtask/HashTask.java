package pers.huangpy.main.appointtask;

import java.util.List;

public class HashTask extends Strategy{

    public HashTask(){
        strategyName = "HashTask";
    }

    @Override
    public void appointTask(List<ServerDTO> servers, TaskDTO task) {
        int hashCode = compHashCode((int)(long)task.getTaskId()) % servers.size();
        doAddList(servers.get(hashCode), task);
    }

    public static int compHashCode(Integer hashcode){
        String s = String.valueOf(hashcode);
        s = String.valueOf(s.hashCode());
        int s1=0;
        int s2=0;
        int s3=0;
        int s4=0;
        for(int i=0;i<s.length();i++) {
            if (i % 3 == 0) {
                s1 += Integer.parseInt(s.substring(i, i + 1));
                s1 = s1 * 7;
            }else if(i % 3 == 1){
                s2 += Integer.parseInt(s.substring(i, i + 1));
                s2 = s2 * 5;
            }else {
                s3 += Integer.parseInt(s.substring(i, i + 1));
                s3 = s3 * 3;
            }
        }
        s4 = s1 + s2 + s3;

        s4 = addDigits(s4);
        //System.out.print(s4 + ":");
        return s4;
    }

    public static int addDigits(Integer num){
        int max = 255;
        int s1 = 0,s2 = 0, s3 = 0;
        if(num > max){
            String s = String.valueOf(String.valueOf(num).hashCode());
            for(int i=0;i<s.length();i++) {
                if (i % 3 == 0) {
                    s1 += Integer.parseInt(s.substring(i, i + 1));
                }else if(i % 3 == 1){
                    s2 += Integer.parseInt(s.substring(i, i + 1));
                }else {
                    s3 += Integer.parseInt(s.substring(i, i + 1));
                }
            }
        }else{
            return num;
        }
        return (s3 + s2 + s1);
    }

}
