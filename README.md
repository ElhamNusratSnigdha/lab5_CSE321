# lab5_CSE321
CPU Scheduling

Given the list of processes, their CPU burst times, arrival times and priorities implement SJF, Priority and Round Robin scheduling algorithms on the processes with preemption. For each of the scheduling policies, compute and print the completion Time(CT), Turnaround Time(TAT), and Waiting Time(WT) for each process.
Waiting time: Processes need to wait in the process queue before execution starts and in execution while they get preempted.
Turnaround time: Time elapsed by each process to get completely served. (Difference between submission time and completion time).                                                 
Task 1: SJF Scheduling
Task 2: Priority Scheduling
You may consult the following pseudocode to implement Priority Scheduling.
completed = 0
current_time = 0
while(completed != n) {

    find process with maximum priority time among process that are in ready queue at current_time

    if(process found) {

        if(process is getting CPU for the first time) {

            start_time = current_time

        }

        burst_time = burst_time - 1

        current_time = current_time + 1

        if(burst_time == 0) {

            completion_time  = current_time

            turnaround_time = completion_time - arrival_time

            waiting_time = turnaround_time - burst_time

            response_time = start_time - arrival_time

            mark process as completed

            completed++

        }

    }

    else {

        current_time++

    }

Task 3: Round Robin

Time Quantum = 4 ms

Check for incoming processes after every time quantum (4 ms).

N.B.

Input for each task will be :

Number of processes
Arrival time of each process. If all processes arrive at the same time, this can be set to 0 for all processes.
Burst time of each process
Priority of each process (If required)
Output will be:

Completion Time(CT), Turnaround Time(TAT), Waiting Time(WT)
Average turnaround Time, average waiting time
