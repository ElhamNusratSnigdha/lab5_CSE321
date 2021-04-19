import java.util.*;
public class RoundRobin_Preemptive {
    public static void main(String[] args) {
        Scanner ens = new Scanner(System.in);

        System.out.println("Enter number of process");
        int n = ens.nextInt();
        String pID[] = new String[n];
        int burstTime[] = new int[n];
        int remBT[] = new int[n];
        int turnaroundTime[] = new int[n];
        int waitingTime[] = new int[n];
        int t,s=0,c=0,i;
        float avgWaitingTime = 0, avgTurnaroundTime=0;
        System.out.println("Enter quantum time");
        int qt = ens.nextInt();

        for ( i = 0; i<n ; i++){
            pID[i] = "P" + (i+1);
            System.out.println("Enter burst time for "+pID[i]);
            burstTime[i] = ens.nextInt();
            remBT[i] = burstTime[i];
        }
        while (true){
            for ( i = 0,c=0; i<n; i++){
                t = qt;

                if (remBT[i]==0){
                    c++;
                    continue;
                }

                if (remBT[i]>qt) {
                    remBT[i] = remBT[i] - qt;
                } else {
                    if (remBT[i]>=0){
                        t = remBT[i];
                        remBT[i] = 0;
                    }
                    s = s + t;
                    turnaroundTime[i] = s;
                }
            }
            if (n==c) break;
        }

        for ( i = 0; i<n; i++){
            waitingTime[i] = turnaroundTime[i] - burstTime[i];
            avgWaitingTime += waitingTime[i];
            avgTurnaroundTime += turnaroundTime[i];
            System.out.println(pID[i]+" burst time: "+burstTime[i]+", turnaround time: "+turnaroundTime[i]+", waiting time: "+waitingTime[i]);
        }

        avgWaitingTime = avgWaitingTime/n;
        avgTurnaroundTime = avgTurnaroundTime/n;
        System.out.println("Average waiting time: "+avgWaitingTime);
        System.out.println("Average turnaround time: "+avgTurnaroundTime);

        ens.close();
    }
}
