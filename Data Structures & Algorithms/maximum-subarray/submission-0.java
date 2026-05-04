class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int sum = 0;

        // if nums[i] + maxSoFar > maxSoFar -> include nums[i]
        // if nums[i] + maxSoFar <= 0 reset the sum.

        for(int i = 0 ; i < nums.length ; i++) {
            sum += nums[i];
            maxSoFar = Math.max(sum, maxSoFar);
            if(sum <= 0) {
                sum = 0;
            }
        }

        return maxSoFar;
    }
}