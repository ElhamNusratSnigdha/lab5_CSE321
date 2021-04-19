import java.util.*;
public class Priority_nonPreemptive {
    public static void main(String[] args) {
        Scanner ens = new Scanner(System.in);
        System.out.println("Enter number of process");
        int n = ens.nextInt();
        String pID[] = new String[n];
        int burstTime[] = new int[n];
        int priority[] = new int[n];
        int turnaroundTime[] = new int[n+1];
        int waitingTime[] = new int[n+1];
        float avgWaitingTime =0, avgTurnaroundTime=0;
        int temp;
        String s;

        for (int i = 0; i<n ; i++){
            pID[i] = "P" + (i+1);
            System.out.println("Enter burst time for "+pID[i]);
            burstTime[i] = ens.nextInt();
            System.out.println("Enter priority for "+pID[i]);
            priority[i] = ens.nextInt();
        }

        for (int i = 0; i<n; i++){
            for (int j = 0; j<n-1; j++){
                if (priority[j]>priority[j+1]){
                    temp = priority[j];
                    priority[j] = priority[j+1];
                    priority[j+1] = temp;

                    temp = burstTime[j];
                    burstTime[j] = burstTime[j+1];
                    burstTime[j+1] = temp;

                    s = pID[j];
                    pID[j] = pID[j+1];
                    pID[j+1] = s;
                }
            }
        }
        for (int i=0; i<n; i++){
            turnaroundTime[i] = burstTime[i] + waitingTime[i];
            waitingTime[i+1] = turnaroundTime[i];
        }

        for (int i = 0; i<n; i++){
            System.out.println(pID[i]+" burst time: "+burstTime[i]+", turnaround time: "+turnaroundTime[i]+", waiting time: "+waitingTime[i]);
            avgWaitingTime += waitingTime[i];
            avgTurnaroundTime += waitingTime[i]+burstTime[i];
        }

        avgWaitingTime = avgWaitingTime/n;
        avgTurnaroundTime = avgTurnaroundTime/n;
        System.out.println("Average waiting time: "+avgWaitingTime);
        System.out.println("Average turnaround time: "+avgTurnaroundTime);

        ens.close();
    }
}
