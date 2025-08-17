import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stocks {
    public  static int buyMaximumProducts(int[] price, int k){
        int n = price.length;
        List<int[]> days = new ArrayList<>();
        for (int i = 0; i < n; i++){
            days.add(new int[]{price[i], i+1});
        }
        days.sort(Comparator.comparingInt(a -> a[0]));
        int totalStocks = 0;
        for (int[] d : days){
            int stockPrice = d[0];
            int limit = d[1];


            int affordable = k/stockPrice;
            int buy = Math.min(limit, affordable);
            totalStocks += buy;
            k -= buy * stockPrice;

            if (k == 0) break;
        }
        return totalStocks;
    }
}
