class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        int jumps = 1;
        int maxIndexReach = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            maxIndexReach = Math.max(maxIndexReach, i + nums[i]);
            if (maxIndexReach >= nums.length - 1) {
                return end >= nums.length - 1 ? jumps : jumps + 1;
            }
            if (i == end) {
                end = maxIndexReach;
                jumps++;
                if(end >= nums.length - 1) {
                    break;
                }
            }
        }
        return jumps;
    }
}