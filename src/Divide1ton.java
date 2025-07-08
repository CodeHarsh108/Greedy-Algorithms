import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Divide1ton {
    public static void divide(int n){
        List<Integer> group1 = new ArrayList<>();
        List<Integer> group2 = new ArrayList<>();
        long sum1 = 0;
        long sum2 = 0;
        for(int i = n; i >= 1; i--){
            if(sum1 <= sum2){
                group1.add(i);
                sum1 += i;
            }else{
                group2.add(i);
                sum2 += i;
            }
        }
        System.out.println("Group 1 Size: " + group1.size());
        System.out.println("Group 1 Elements: " + group1);
        System.out.println("Group 2 Size: " + group2.size());
        System.out.println("Group 2 Elements: " + group2);

        System.out.println("Difference in Sum: " + Math.abs(sum1 - sum2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        divide(n);
    }
}
