import java.util.Scanner;

public class LargestPalindrome {

    public static String largestPalindromic(String num) {
        int[] freq = new int[10];
        for (char ch : num.toCharArray()) {
            freq[ch - '0']++;
        }

        StringBuilder left = new StringBuilder();
        String mid = "";

        for (int i = 9; i >= 0; i--) {
            while (freq[i] >= 2) {
                if (i != 0 || !left.isEmpty()) {
                    left.append(i);
                    freq[i] -= 2;
                } else {
                    break;
                }
            }
        }

        for (int i = 9; i >= 0; i--) {
            if (freq[i] > 0) {
                mid = String.valueOf(i);
                break;
            }
        }

        String right = new StringBuilder(left).reverse().toString();
        String res = left.toString() + mid + right;

        if (res.replace("0", "").isEmpty()) return "0";

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🔢 Enter digits to form the largest palindrome (type 'exit' to quit):");

        while (true) {
            System.out.print("Input: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("🚪 Exiting...");
                break;
            }

            if (!input.matches("\\d+")) {
                System.out.println("⚠️ Please enter digits only (0-9).");
                continue;
            }

            String result = largestPalindromic(input);
            System.out.println("✅ Largest Palindromic Number: " + result);
            System.out.println("-----------------------------------");
        }

        scanner.close();
    }
}
