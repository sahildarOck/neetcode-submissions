class Solution {
    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length - 1);
    }

    private int searchInsert(int[] nums, int target, int start, int end) {
        if(start > end) {
            return start;
        }
        int mid = end - (end - start) / 2;
        if(nums[mid] == target) {
            return mid;
        }
        if(nums[mid] > target) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }

        return searchInsert(nums, target, start, end);
    }
}