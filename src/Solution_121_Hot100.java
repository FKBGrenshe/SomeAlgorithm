public class Solution_121_Hot100 {
    public int maxProfit(int[] prices) {
        // 买的那天一定是卖的那天之前的最小值
        // 每到一天，维护之前的最小值
        int minImportValue = 10001;
        int maxPro = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i-1] <= minImportValue){
                minImportValue = prices[i-1];
            }
            maxPro = Math.max(prices[i] - minImportValue, maxPro);
        }
        return maxPro;
    }
}
