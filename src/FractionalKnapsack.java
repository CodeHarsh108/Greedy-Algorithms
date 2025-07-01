import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {
    static class Item implements Comparable<Item>{
        int profit;
        int weight;

        Item(int profit, int weight){
            this.profit = profit;
            this.weight = weight;
        }
        @Override
        public int compareTo(Item other) {
            double ratio1 = (double) this.profit /this.weight;
            double ratio2 = (double) other.profit /other.weight;
            return Double.compare(ratio2, ratio1);
        }
    }
    public static double fractionalKnapsack(int capacity, Item[] items){
        Arrays.sort(items);
        double total = 0.0;
        for(Item item : items){
            if (capacity <= 0) break;
            if (item.weight <= capacity){
                total += item.profit;
                capacity -= item.weight;
            }else{
                double fraction = (double) capacity/ item.weight;
                total += fraction * item.profit;
                capacity = 0;
            }
        }
        return total;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = scanner.nextInt();

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter profit of item " + (i + 1) + ": ");
            int profit = scanner.nextInt();

            System.out.print("Enter weight of item " + (i + 1) + ": ");
            int weight = scanner.nextInt();

            items[i] = new Item(profit, weight);
        }

        double maxProfit = fractionalKnapsack(capacity, items);
        System.out.println("Maximum profit that can be obtained: " + maxProfit);

        scanner.close();
    }
    }
