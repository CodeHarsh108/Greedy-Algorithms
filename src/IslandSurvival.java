import java.util.Scanner;

public class IslandSurvival {
    public static int minimumDays(int S, int N, int M) {
        double requirement = S * M;

        // Shop is closed on Sundays, so only (S - S/7) days to buy
        if ((S - S / 7) * N < requirement) {
            return -1; // Not possible to survive
        } else {
            return (int) Math.ceil(requirement / N);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🟡 Welcome to Island Survival Simulator 🏝️");
        System.out.print("🔹 Enter number of days you need to survive (S): ");
        int S = scanner.nextInt();

        System.out.print("🔹 Enter max units of food you can buy each day (N): ");
        int N = scanner.nextInt();

        System.out.print("🔹 Enter units of food needed per day to survive (M): ");
        int M = scanner.nextInt();

        int result = minimumDays(S, N, M);

        if (result == -1) {
            System.out.println("❌ Sorry, survival is impossible with the given constraints.");
        } else {
            System.out.println("✅ Minimum number of days you need to buy food: " + result);
        }

        scanner.close();
    }
}
