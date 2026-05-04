class Solution {
    public int rob(int[] nums) {
        // 9 1 3 10
        // 9 9 max(n - 1, n - 2 + n)
        int nMinusOne = 0;
        int nMinusTwo = 0;

        int curr = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            curr = Math.max(nums[i] + nMinusTwo, nMinusOne);
            nMinusTwo = nMinusOne;
            nMinusOne = curr;
        }

        return curr;
    }
}