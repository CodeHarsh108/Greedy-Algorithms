import java.util.Scanner;

public class SmallestSumNumber {
    public String smallestNumber(int S, int D) {
        if (S > 9 * D || (S == 0 && D > 1)) {
            return "Not Possible";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < D; i++) {
            int start = (i == 0) ? 1 : 0;
            for (int d = start; d <= 9; d++) {
                if (S - d <= 9 * (D - i - 1)) {
                    result.append(d);
                    S -= d;
                    break;
                }
            }
        }

        return result.toString();
    }

    // Tester with interactive user input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the required sum of digits (S): ");
        int S = sc.nextInt();

        System.out.print("Enter the number of digits (D): ");
        int D = sc.nextInt();

        SmallestSumNumber solver = new SmallestSumNumber();
        String result = solver.smallestNumber(S, D);

        System.out.println("Smallest " + D + "-digit number with digit sum " + S + " is: " + result);

        sc.close();
    }
}
