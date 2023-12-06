import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            ArrayList<Integer> prices = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                prices.add(scanner.nextInt());
            }
            int result = maximumProfit(prices);
            System.out.println(result);
        }
        scanner.close();
    }
    
    public static int maximumProfit(ArrayList<Integer> prices) {
        if (prices == null || prices.size() <= 1) {
            return 0;
        }

        int maxProfit = 0;
        int minPrice = prices.get(0);

        for (int i = 1; i < prices.size(); i++) {
            int currentPrice = prices.get(i);
            if (currentPrice < minPrice) {
                minPrice = currentPrice;
            } else {
                int profit = currentPrice - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}
