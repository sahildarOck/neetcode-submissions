class Solution {
    public int climbStairs(int n) {
        int[] ways = new int[n + 1];
        Arrays.fill(ways, 0);
        return getNumberOfWays(n, ways);
    }

    private int getNumberOfWays(int stepsLeft, int[] ways) {
        // System.out.println("stepsLeft: " + stepsLeft);
        // Arrays.stream(ways).forEach(x -> System.out.print(x + " "));
        if(ways[stepsLeft] != 0) {
            return ways[stepsLeft];
        }
        if(stepsLeft == 2) {
            ways[2] = 2;
            return 2;
        }
        if(stepsLeft == 1) {
            ways[1] = 1;
            return 1;
        }
        ways[stepsLeft] = getNumberOfWays(stepsLeft - 1, ways) + getNumberOfWays(stepsLeft - 2, ways);
        return ways[stepsLeft];
    }
}
