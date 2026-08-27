class Solution {
    public int maxProfit(int[] prices) {
        int buyIndex = 0;
        int maxProfit = 0;
        for(int i = 1 ; i < prices.length ; i++) {
            if(prices[i] < prices[buyIndex]) {
                buyIndex = i;
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - prices[buyIndex]);
            }
        }

        return maxProfit;
    }
}