import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ShortestJobFirst {


    static class Process{
        int pid;
        int at;
        int bt;
        int ct;
        int tat;
        int wt;
        Process(int pid, int at, int bt){
            this.pid = pid;
            this.at = at;
            this.bt = bt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        Process[] processes = new Process[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Arrival Time and Burst Time for P" + (i + 1) + ": ");
            int at = sc.nextInt();
            int bt = sc.nextInt();
            processes[i] = new Process(i + 1, at, bt);
        }

        Arrays.sort(processes, Comparator.comparingInt(p -> p.at));
        int time = 0;
        int completed = 0;
        boolean[] visited = new boolean[n];
        while(completed < n){
            int idx = -1;
            int minBT = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                if(!visited[i] && processes[i].at <= time && processes[i].bt < minBT){
                    minBT = processes[i].bt;
                    idx = i;
                }
            }
            if(idx != -1){
                time += processes[idx].bt;
                processes[idx].ct = time;
                processes[idx].tat = processes[idx].ct - processes[idx].at;
                processes[idx].wt = processes[idx].tat - processes[idx].bt;

                visited[idx] = true;
                completed++;
            }else{
                time++;
            }
        }
        System.out.println("\nPID\tAT\tBT\tCT\tTAT\tWT");
        double totalTAT = 0, totalWT = 0;
        for (Process p : processes) {
            System.out.println("P" + p.pid + "\t" + p.at + "\t" + p.bt + "\t" + p.ct + "\t" + p.tat + "\t" + p.wt);
            totalTAT += p.tat;
            totalWT += p.wt;
        }

        // Averages
        System.out.printf("\nAverage Turnaround Time: %.2f", (totalTAT / n));
        System.out.printf("\nAverage Waiting Time: %.2f", (totalWT / n));
    }
}
