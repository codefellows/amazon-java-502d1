import java.util.ArrayList;
import java.util.List;

public class MaximizeStockTrades {
    public static void main(String[] args) {
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        List<Trade> trades = analyzeMarket(prices);
        int totalProfit = 0;
        for (Trade trade : trades) {
            System.out.println(trade.toString());
            totalProfit += trade.sellPrice - trade.buyPrice;
        };
        System.out.println("Total profit: " + totalProfit);
    }

    public static List<Trade> analyzeMarket(int[] prices) {
        List<Trade> trades = new ArrayList<>();
        int i = 0;
        while (i < prices.length) {
            Trade trade = new Trade();
            boolean isBuySet = false;
            boolean isSellSet = false;

            while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                i++;
            }
            if (i < prices.length) {
                trade.buyPrice = prices[i];
                isBuySet = true;
            }

            while (i < prices.length - 1 && prices[i + 1] >= prices[i]) {
                i++;
            }
            if (i < prices.length) {
                trade.sellPrice = prices[i];
                isSellSet = true;
            }

            if (isBuySet && isSellSet) {
                trades.add(trade);
            }
            i++;
        }
        return trades;
    }
}
