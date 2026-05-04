class Solution {
    public int search(int[] nums, int target) {
        if(nums[0] == target) {
            return 0;
        }
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        boolean inFirstArray = false;
        if(nums[0] < target) {
            inFirstArray = true;
        }

        // find the end of firstArray
        int firstArrEndIndex = nums.length - 1;
        int mid;
        while(start <= end) {
            mid = (start + end ) / 2;
            if(mid == nums.length - 1 || nums[mid] > nums[mid + 1]) {
                firstArrEndIndex = mid;
                break;
            }
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if(inFirstArray) {
            start = 0;
            end = firstArrEndIndex;
        } else {
            start = firstArrEndIndex + 1;
            end = nums.length - 1;
        }

        while(start <= end) {
            mid = (start + end ) / 2;

            if(nums[mid] == target) {
                ans = mid;
                break;
            }
            if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}
