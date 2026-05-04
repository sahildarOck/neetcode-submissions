class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int ans = nums[start];
        while(start <= end) {
            if(nums[start] < nums[end]) {
                ans = Math.min(ans, nums[start]);
                break;
            }
            mid = (start + end) / 2;
            ans = Math.min(ans, nums[mid]);
            if(nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
