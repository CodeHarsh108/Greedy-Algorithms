import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyNotes {
    public static void findMinNotes(int amount){
        int[] denominations = {2000, 500, 200, 100, 50, 20, 10, 5, 1};
        Map<Integer, Integer> counts = new LinkedHashMap<>();
        for(int note : denominations){
            if(amount >= note){
                int count = amount/note;
                amount -= count * note;
                counts.put(note, count);
            }
        }
        System.out.println("Minimum notes required:");
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount: ");
        int amount = sc.nextInt();
        findMinNotes(amount);
    }
}
