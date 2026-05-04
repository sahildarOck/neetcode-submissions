class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] numsCopy = new int[nums.length];
        List<Integer> numsComplementList = new ArrayList<>();

        int[] result = new int[2];
        for(int i = 0 ; i < nums.length ; i++) {
            if(numsComplementList.contains(nums[i])) {
                result[0] = numsComplementList.indexOf(nums[i]);
                result[1] = i;
                break;
            }
            numsComplementList.add(target - nums[i]);
        }
        return result;
    }
}
