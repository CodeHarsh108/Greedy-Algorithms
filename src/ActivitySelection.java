import java.util.Arrays;
import java.util.Scanner;

public class ActivitySelection {
    static class Activity implements Comparable<Activity>{
        int start;
        int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity other) {
            return this.end - other.end;
        }
    }

    public static int selectActivity(Activity[] activities){
        Arrays.sort(activities);
        int count = 1;
        int prevEnd = activities[0].end;
        for (int i = 1; i < activities.length; i++) {
            if(activities[i].start >= prevEnd){
                count++;
                prevEnd = activities[i].end;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of activities: ");
        int n = scanner.nextInt();

        Activity[] activities = new Activity[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter start time for activity " + (i + 1) + ": ");
            int start = scanner.nextInt();
            System.out.print("Enter end time for activity " + (i + 1) + ": ");
            int end = scanner.nextInt();
            activities[i] = new Activity(start, end);
        }

        int result = selectActivity(activities);

        System.out.println("Maximum number of activities that can be selected: " + result);

        scanner.close();
    }
}
