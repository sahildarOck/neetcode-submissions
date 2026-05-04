class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }

        int adj = nums[1];
        int allowed = nums[0];

        int temp;
        for(int i = 2 ; i < nums.length ; i++) {
            temp = nums[i] + allowed;
            if(adj > allowed) {
                allowed = adj;
            }
            adj = temp;
        }
        return adj > allowed ? adj : allowed;
    }
}