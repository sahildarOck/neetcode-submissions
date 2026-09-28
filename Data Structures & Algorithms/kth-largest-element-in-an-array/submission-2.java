class Solution {
    private final Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }

    private int findKthLargest(int[] nums, int k, int low, int high) {
        if(low <= high) {
            int pivotIndex = partition(nums, low, high);
            if(pivotIndex == nums.length - k) {
                return nums[pivotIndex];
            }
            if(pivotIndex < nums.length - k) {
                return findKthLargest(nums, k, pivotIndex + 1, high);
            }
            return findKthLargest(nums, k, low, pivotIndex - 1);
        }
        return -1;
    }

    private int partition(int[] nums, int low, int high) {
        int pivotIndex = low + rand.nextInt(high - low + 1);
        int pivotValue = nums[pivotIndex];
        swap(nums, low, pivotIndex);

        int i = low + 1;
        int j = high;

        while(i <= j) {
            while(i <= j && nums[i] < pivotValue) {
                i++;
            }
            while(i <= j && nums[j] > pivotValue) {
                j--;
            }
            if(i >= j) {
                break;
            }
            swap(nums, i, j);
            i++;
            j--;
        }

        swap(nums, low, j);

        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}