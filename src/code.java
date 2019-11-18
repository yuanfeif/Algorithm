import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
public class code {
    public static void main(String[] args) {
        Comparator<Patient> Order = (o1, o2) -> {
            int num_1 = o1.getPriority_num();
            int num_2 = o2.getPriority_num();
            return Integer.compare(num_2, num_1);
        };
        Queue<Patient> priorityQueue1 = new PriorityQueue<>(Order);
        Queue<Patient> priorityQueue2 = new PriorityQueue<>(Order);
        Queue<Patient> priorityQueue3 = new PriorityQueue<>(Order);

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int id = 0;
            int t = in.nextInt();
            for(int i = 0; i < t; i++){
                String condition = in.next();
                if(condition.equals("IN")) {
                    id++;
                    int doctorNum = in.nextInt();
                    int priorityNum = in.nextInt();
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
                    int doctorNum = in.nextInt();
                    Patient tmp;
                    if(doctorNum == 1){
                        if(!priorityQueue1.isEmpty()){
                            tmp = priorityQueue1.poll();
                            System.out.println(tmp.getId());
                        }
                        else {
                            System.out.println("EMPTY");
                        }
                    }
                    else if(doctorNum == 2){
                        if(!priorityQueue2.isEmpty()){
                            tmp = priorityQueue2.poll();
                            System.out.println(tmp.getId());
                        }
                        else {
                            System.out.println("EMPTY");
                        }
                    }
                    else if(doctorNum == 3){
                        if(!priorityQueue3.isEmpty()){
                            tmp = priorityQueue3.poll();
                            System.out.println(tmp.getId());
                        }
                        else {
                            System.out.println("EMPTY");
                        }
                    }
                }
            }
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
