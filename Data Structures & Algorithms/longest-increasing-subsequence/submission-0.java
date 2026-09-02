class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        int ans = 1;
        for(int i = 0 ; i < nums.length ; i++) {
            dp[i] = getLISLengthTillHere(nums, i, dp);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    private int getLISLengthTillHere(int[] nums, int j, int[] dp) {
        int length = 1;
        for(int i = j - 1 ; i > -1 ; i--) {
            if(nums[i] < nums[j]) {
                length = Math.max(dp[i] + 1, length);
            }
        }
        return length;
    }
}