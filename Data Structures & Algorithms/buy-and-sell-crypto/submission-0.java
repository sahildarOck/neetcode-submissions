class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = prices[0];

        for(int i = 1 ; i < prices.length ; i++) {
            if(buyPrice > prices[i - 1]) {
                buyPrice = prices[i - 1];
            }
            if(maxProfit < prices[i] - buyPrice) {
                maxProfit = prices[i] - buyPrice;
            }
        }

        return maxProfit;
    }
}
