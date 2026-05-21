class Solution {
    public int subsetXORSum(int[] nums) {
        int xor = 0;
        return subsetXORSum(nums, 0, 0);
    }

    private int subsetXORSum(int[] nums, int xor, int index) {
        if(index == nums.length) {
            return xor;
        }
        int xorIncluding = subsetXORSum(nums, xor ^ nums[index], index + 1);
        int xorExcluding = subsetXORSum(nums, xor, index + 1);
        return xorIncluding + xorExcluding;
    }
}