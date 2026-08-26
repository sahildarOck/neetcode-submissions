class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // [-2, -2, -2, 3, 3]
        // [-1, -1, 1, -3, 2, 4]
        // [0, -1, 0]
        // [-1, 3, -4, 2]

        int total = 0;
        int curr = 0;
        int start = 0;

        for(int i = 0 ; i < gas.length ; i++) {
            int gain = gas[i] - cost[i];

            total += gain;
            curr += gain;

            if(curr < 0) {
                start = i + 1;
                curr = 0;
            }
        }

        return total > -1 ? start : -1;
    }
}