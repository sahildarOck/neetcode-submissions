class Solution {
    public int rob(int[] nums) {
        // 0 -> num.length - 2
        // 1 -> nums.length - 1
        if(nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, false), rob(nums, true));
    }

    private int rob(int[] nums, boolean lastIncluded) {
        int nMinusOneMoney = 0;
        int nMinusTwoMoney = 0;
        int curr = 0;

        int endIndex = lastIncluded ? nums.length - 1 : nums.length - 2;
        int startIndex = lastIncluded ? 1 : 0;
        while(startIndex <= endIndex) {
            curr = Math.max(nMinusOneMoney, nMinusTwoMoney + nums[startIndex++]);
            nMinusTwoMoney = nMinusOneMoney;
            nMinusOneMoney = curr;
        }

        return curr;
    }
}
