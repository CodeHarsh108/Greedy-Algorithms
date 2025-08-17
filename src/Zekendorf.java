import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zekendorf {

    public static int minFibonacci(int k) {
        List<Integer> fibs = new ArrayList<>();
        fibs.add(1);
        fibs.add(2);

        // generate all Fibonacci numbers up to k
        while (fibs.get(fibs.size() - 1) <= k) {
            int size = fibs.size();
            fibs.add(fibs.get(size - 1) + fibs.get(size - 2));
        }

        int count = 0;
        int i = fibs.size() - 1;

        // greedy selection
        while (k > 0) {
            if (fibs.get(i) <= k) {
                k -= fibs.get(i);
                count++;
            } else {
                i--;
            }
        }
        return count;
    }

    // interactive main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            System.out.print("Enter K ");
            int K = sc.nextInt();
            int result = minFibonacci(K);
            System.out.println("Minimum Fibonacci terms for " + K + " = " + result);


        sc.close();
    }
}
