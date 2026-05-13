class Solution {
    public int maxProfit(int[] prices) {
        // can't sell on 1st day
        // can't buy on last day
        int maxProfit = 0;
        int buyPrice = prices[0];
        int currProfit;
        for(int i = 1 ; i < prices.length ; i++) {
            while(i < prices.length && buyPrice > prices[i]) {
                buyPrice = prices[i];
                i++;
                // System.out.println("1st while loop");
                // System.out.println("buyPrice: " + buyPrice);
                // System.out.println("i: " + i);
                // System.out.println();
            }
            if(i == prices.length) {
                break;
            }
            currProfit = prices[i] - buyPrice;
            i++;
            while(i < prices.length && currProfit < prices[i] - buyPrice) {
                currProfit = prices[i] - buyPrice;
                i++;
                // System.out.println("2nd while loop");
                // System.out.println("currProfit: " + currProfit);
                // System.out.println("i: " + i);
                // System.out.println();
            }
            maxProfit += currProfit;
            if(i == prices.length) {
                break;
            }
            buyPrice = prices[i];
            // System.out.println("exited both while loops");
            // System.out.println("maxProfit: " + maxProfit);
            // System.out.println("buyPrice: " + buyPrice);
            // System.out.println("****************");
        }
        return maxProfit;
    }
}