class Solution {
    public int removeDuplicates(int[] nums) {
        int front = 0;

        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] != nums[front]) {
                front++;
                nums[front] = nums[i];
            }
        }
        return front + 1;
    }
}