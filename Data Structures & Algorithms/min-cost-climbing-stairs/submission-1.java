class Solution {
    public int minCostClimbingStairs(int[] cost) {
       // 1 1 2 100 10
        int second = cost[cost.length - 1];
        int first = cost[cost.length - 2];
        int temp;
        for(int i = cost.length - 3 ; i > -1 ; i--) {
            temp = Math.min(first, second) + cost[i];
            second = first;
            first = temp;
        }

        return Math.min(first, second);
    }
}
