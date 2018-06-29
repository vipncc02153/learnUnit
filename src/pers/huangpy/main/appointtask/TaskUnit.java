package pers.huangpy.main.appointtask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskUnit {

    private Long nowid = (long)0;

    private List<ServerDTO> servers = new ArrayList<>();

    private List<TaskDTO> tasks = new ArrayList<>();

    private Byte ipPostfix = (byte)1;

    private List<? extends Strategy> strategies = new ArrayList<Strategy>(){{
        add(new AverageTask());
        add(new HashTask());
        add(new RandomTask());
    }};

    public void taskUnit(){

        t:while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("请选择你需要进行的操作:1.新建任务 2.增加服务器 3.查看服务器列表及其任务列表 4.查看所有任务及归属的服务器（IP）5.查看单个服务器上运行的任务（ID） 按其他任意按钮结束程序");
            Integer jin = scan.nextInt();
            switch (jin){
                case 1:createTask();break;

                case 2:createServer();break;

                case 3:printServer();break;

                case 4:printTask();break;

                case 5:printTaskInServer();break;

                default: break t;

            }
        }
    }

    private void createTask(){
        Strategy strategy = appoTask();
        for(int i = 0; i < 50 ; i++) {
            TaskDTO task = new TaskDTO(this.nowid);


            if (servers.size() != 0) {
                strategy.execStrategy(servers, task);
                this.tasks.add(task);
                System.out.println("新建任务成功，新任务ID为：" + task.getTaskId());
                nowid++;
            } else {
                System.out.println("当前无可用服务器，新建任务失败");
            }
        }
    }

    private Strategy appoTask(){
        System.out.print("请选择分配任务的策略: ");
        Integer index = 1;
        for(Strategy strategy: strategies){
            System.out.print(" " + index++ + "." +strategy.getStrategyName());
        }
        System.out.println();
        Scanner scan = new Scanner(System.in);
        Integer jin = scan.nextInt();
        System.out.println("选择了" + strategies.get(jin-1).getStrategyName() + "策略");
        return strategies.get(jin-1);
    }

    private void createServer(){
        Integer ipPostfix = this.ipPostfix++&0xff;
        String ipAddress = "192.168.1." + String.valueOf(ipPostfix);
        ServerDTO server = new ServerDTO(ipAddress);
        this.servers.add(server);
        System.out.println("成功创建IP地址为: " + server.getIpAddress() + "的服务器" );
    }

    private void printServer(){
        for(ServerDTO server :this.servers){
            System.out.println("IP地址为: " + server.getIpAddress() + " 的服务器运行着 " + server.getTaskSum() + "个任务" );
        }
    }

    private void printTask(){
        for(TaskDTO task :this.tasks){
            System.out.println("任务taskId: " + task.getTaskId() + " 当前正在IP地址为: " + task.getIpAddress() + "的服务器上运行");
        }
    }

    private void printTaskInServer(){
        System.out.print("请选择要查看任务的服务器IP地址后缀: ");
        Scanner scan = new Scanner(System.in);
        Integer jin = scan.nextInt();
        System.out.println("所选服务器: 192.168.1." + String.valueOf(jin) + " 运行着以下任务");
        for(Long taskId: servers.get(jin-1).getTaskIdList()){
            System.out.println("任务Id: " + taskId);
        }
    }
}
