class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // 1 1 2 100 10
        int[] dp = new int[cost.length];

        dp[cost.length - 1] = cost[cost.length - 1];
        dp[cost.length - 2] = cost[cost.length - 2];
        for(int i = cost.length - 3 ; i > -1 ; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }

        return Math.min(dp[0], dp[1]);
    }
}
