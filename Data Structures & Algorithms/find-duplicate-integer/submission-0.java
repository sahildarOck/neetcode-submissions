class Solution {
    public int findDuplicate(int[] nums) {
        int ans = -1;
        for(int n : nums) {
            int num = Math.abs(n);
            if(nums[num] < 0) {
                ans = num;
                break;
            } else {
                nums[num] *= -1;
            }
        }
        return ans;
    }
}
