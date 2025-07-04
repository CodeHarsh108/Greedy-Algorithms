import java.util.Arrays;
import java.util.Scanner;

public class CutABoard {
    private static void reverse(int[] array){
        int l = 0, r = array.length-1;
        while(l < r){
            int tmp = array[l];
            array[l] = array[r];
            array[r] = tmp;
            l++;
            r--;
        }
    }
    public static int minimumCostOfBreaking(int[] X, int[] Y, int M, int N) {
        Arrays.sort(X);
        Arrays.sort(Y);
        reverse(X);
        reverse(Y);
        int hPieces = 1;
        int vPieces = 1;
        int i = 0;
        int j = 0;
        int totalCost = 0;
        while(i < X.length && j < Y.length){
            if(X[i] > Y[j]){
                totalCost += X[i] * vPieces;
                hPieces++;
                i++;
            }else{
                totalCost += Y[j] * hPieces;
                vPieces++;
                j++;
            }
        }
        while(i < X.length){
            totalCost += X[i] * vPieces;
            i++;
        }
        while(j < Y.length){
            totalCost += Y[j] * hPieces;
            j++;
        }
        return totalCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input M and N (board dimensions)
        System.out.print("Enter the number of horizontal segments (M): ");
        int M = sc.nextInt();
        System.out.print("Enter the number of vertical segments (N): ");
        int N = sc.nextInt();

        int[] X = new int[M - 1]; // Horizontal cuts
        int[] Y = new int[N - 1]; // Vertical cuts

        // Input horizontal cut costs
        System.out.println("Enter " + (M - 1) + " horizontal cut costs:");
        for (int i = 0; i < M - 1; i++) {
            X[i] = sc.nextInt();
        }

        // Input vertical cut costs
        System.out.println("Enter " + (N - 1) + " vertical cut costs:");
        for (int i = 0; i < N - 1; i++) {
            Y[i] = sc.nextInt();
        }

        int minCost = CutABoard.minimumCostOfBreaking(X, Y, M, N);

        System.out.println("💰 Minimum cost to cut the board: " + minCost);
        sc.close();
    }
}
