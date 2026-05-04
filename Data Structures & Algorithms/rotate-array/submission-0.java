class Solution {
    public void rotate(int[] nums, int k) {
        rotate(nums, k, 0);
    }

    private void rotate(int[] nums, int k, int index) {
        if(index == nums.length) {
            return;
        }
        int postRotationIndex = (index + k) % nums.length;
        int num = nums[index];

        rotate(nums, k, index + 1);

        nums[postRotationIndex] = num;
    }
}