import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MaximumMeetings {



    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;
        int index;

        @Override
        public int compareTo(Meeting other) {
            return Integer.compare(this.end, other.end);
        }
    }




    public static void printMaximum(List<Meeting> meetingList){
        Collections.sort(meetingList);
        List<Integer> selected = new ArrayList<>();
        int count = 1;
        int endTime = meetingList.get(0).end;
        selected.add(meetingList.get(0).index);
        for (int i = 1; i < meetingList.size(); i++) {
            if (meetingList.get(i).start > endTime){
                count++;
                endTime = meetingList.get(i).end;
                selected.add(meetingList.get(i).index);
            }
        }
        for (int i = 0; i < selected.size(); i++) {
            System.out.println(selected.get(i) + " ");
        }
        System.out.println();
    }





    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of meetings: ");
        int n = scanner.nextInt();

        List<Meeting> meetingList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter start time for meeting " + (i + 1) + ": ");
            int start = scanner.nextInt();
            System.out.print("Enter end time for meeting " + (i + 1) + ": ");
            int end = scanner.nextInt();

            Meeting meeting = new Meeting();
            meeting.start = start;
            meeting.end = end;
            meeting.index = i + 1;

            meetingList.add(meeting);
        }

        // Call the printMaximum method to select meetings
        printMaximum(meetingList);

        scanner.close();

    }
}
