class Solution {
    public int subarraySum(int[] nums, int k) {
        int total = 0;
        int currSum = 0;

        for(int i = 0 ; i < nums.length ; i++) {
            currSum = nums[i];
            if(currSum == k) {
                total++;
            }
            for(int j = i + 1 ; j < nums.length ; j++) {
                currSum += nums[j];
                if(currSum == k) {
                    total++;
                }
            }
        }

        return total;
    }
}