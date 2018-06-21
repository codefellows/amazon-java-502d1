public class Trade {
    public int buyPrice;
    public int sellPrice;

    public String toString() {
        int profit = sellPrice - buyPrice;
        return String.format("buy: %d sell: %d profit: %d", buyPrice, sellPrice, profit);
    }
}
