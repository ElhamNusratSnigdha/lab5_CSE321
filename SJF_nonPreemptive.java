import java.util.*;
public class SJF_nonPreemptive {
    public static void main(String[] args) {
        Scanner ens = new Scanner(System.in);
        System.out.println("Enter number of process");
        int n = ens.nextInt();
        int pID[] = new int[n];
        int arrivalTime[] = new int[n];
        int burstTime[] = new int[n];
        int finishTime[] = new int[n];
        int turnaroundTime[] = new int[n];
        int waitingTime[] = new int[n];
        int responseTime[] = new int[n];
        int flag[] = new int[n]; //flag checks complete or not
        int start = 0, total = 0;
        float avgWaitingTime = 0, avgTurnaroundTime = 0;

        for (int i=0; i<n; i++){
            System.out.println("Enter process ID");
            pID[i] = ens.nextInt();
            System.out.println("Enter process"+pID[i]+" arrival time");
            arrivalTime[i] = ens.nextInt();
            System.out.println("Enter process"+pID[i]+" burst time");
            burstTime[i] = ens.nextInt();
            System.out.println("Enter 0, cause process"+pID[i]+" is not complete");
            flag[i] = ens.nextInt();
        }

        while (true){
            int c = n, min = 9999;

            //total completed processes=total number of process, loop will be terminated
            if (total==n) break;
            for (int i=0; i<n; i++){
                if (arrivalTime[i]<=start && flag[i]==0 && burstTime[i]<min){
                    min=burstTime[i];
                    c=i;
                }
            }
            if (c==n) start++;
            else{
                finishTime[c] = start+burstTime[c];
                start += burstTime[c];
                turnaroundTime[c] = finishTime[c]-arrivalTime[c];
                waitingTime[c] = turnaroundTime[c] - burstTime[c];
                flag[c] = 1;
                total++;
            }
        }
        for (int i = 0; i<n; i++){
            System.out.println("Process "+pID[i]+", arrival time: "+arrivalTime[i]+", burst time: "+burstTime[i]+", finish " +
                    "time: " + finishTime[i]+", turnaround time: "+turnaroundTime[i]+", waiting time: "+waitingTime[i]);
            avgWaitingTime += waitingTime[i];
            avgTurnaroundTime += turnaroundTime[i];
        }
        avgWaitingTime = avgWaitingTime/n;
        avgTurnaroundTime = avgTurnaroundTime/n;
        System.out.println("Average waiting time: "+avgWaitingTime);
        System.out.println("Average turnaround time: "+avgTurnaroundTime);

        ens.close();
    }
}
