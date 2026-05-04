class Solution {
    public boolean search(int[] nums, int target) {
        // 1 2 3 4 5
        // 2 3 4 5 1
        return search(nums, target, 0, nums.length - 1);
    }

    private boolean search(int[] nums, int target, int left, int right) {
        if(left > right) {
            return false;
        }

        while(left < right && nums[left] == nums[left + 1]) {
            left++;
        }

        while(left < right && nums[right] == nums[right - 1]) {
            right--;
        }

        int mid = right - (right - left) / 2;

        if(nums[mid] == target) {
            return true;
        }

        if(nums[mid] > nums[left]) {
            // pivot on right side
            if(nums[mid] > target && nums[left] <= target) {
                right = mid - 1;
            } else { 
                left = mid + 1;
            }
        } else {
            // pivot on left side
            if(nums[mid] < target && nums[right] >= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return search(nums, target, left, right);
    }
}