class Solution {
     public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int left, int right) {
        if(left > right) {
            return -1;
        }

        int mid = right - (right - left) / 2;

        if(nums[mid] == target) {
            return mid;
        }

        if(nums[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }

        return search(nums, target, left, right);
    }
}
