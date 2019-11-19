import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
class code {
    public static void main(String[] args) {
        Comparator<Patient> Order = (o1, o2) -> {//比较器
            if(o1.getPriority_num() == o2.getPriority_num()){
                return o1.getId()-o2.getId();
            }
            else {
                return o2.getPriority_num()-o1.getPriority_num();
            }
        };
        //代表三个医生的优先队列
        Queue<Patient> priorityQueue1 = new PriorityQueue<>(Order);
        Queue<Patient> priorityQueue2 = new PriorityQueue<>(Order);
        Queue<Patient> priorityQueue3 = new PriorityQueue<>(Order);

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int id = 0;
            int t = in.nextInt();   //总的轮数
            for(int i = 0; i < t; i++){    //“IN”“OUT”操作的次数
                String condition = in.next();   //操作状态
                if(condition.equals("IN")) {
                    id++;
                    int doctorNum = in.nextInt();   //入队的医生编号
                    int priorityNum = in.nextInt();    //优先级
                    //不同医生编号入队
                    if(doctorNum == 1){
                        priorityQueue1.add(new Patient(doctorNum,priorityNum,id));
                    }
                    else if(doctorNum == 2){
                        priorityQueue2.add(new Patient(doctorNum,priorityNum,id));
                    }
                    else if(doctorNum == 3){
                        priorityQueue3.add(new Patient(doctorNum,priorityNum,id));
                    }
                }
                else if(condition.equals("OUT")){
                    int doctorNum = in.nextInt();   //出队的医生编号
                    //不同医生编号输出
                    if(doctorNum == 1){
                        if(!priorityQueue1.isEmpty()){
                            System.out.println(priorityQueue1.poll().getId());
                        }
                        else {
                            System.out.println("EMPTY");
                        }
                    }
                    else if(doctorNum == 2){
                        if(!priorityQueue2.isEmpty()){
                            System.out.println(priorityQueue2.poll().getId());
                        }
                        else {
                            System.out.println("EMPTY");
                        }
                    }
                    else if(doctorNum == 3){
                        if(!priorityQueue3.isEmpty()){
                            System.out.println(priorityQueue3.poll().getId());
                        }
                        else {
                            System.out.println("EMPTY");
                        }
                    }
                }
            }
            //清空队列
            priorityQueue1.clear();
            priorityQueue2.clear();
            priorityQueue3.clear();
        }




    }
}


class Patient{
    int priority_num;
    int doctor_num;
    int id;

    Patient(int doctor_num, int priority_num, int id){
        setDoctor_num(doctor_num);
        setPriority_num(priority_num);
        setId(id);
    }

    public int getDoctor_num() {
        return doctor_num;
    }

    public void setDoctor_num(int doctor_num) {
        this.doctor_num = doctor_num;
    }

    public int getPriority_num() {
        return priority_num;
    }

    public void setPriority_num(int priority) {
        this.priority_num = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
