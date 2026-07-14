class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> numsMap = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++) {
            numsMap.putIfAbsent(nums[i], new ArrayList<>());
            numsMap.get(nums[i]).add(i);
        }

        int[] ans = new int[2];
        for(int i = 0 ; i < nums.length ; i++) {
            int complement = target - nums[i];
            if(numsMap.containsKey(complement)) {
                List<Integer> list = numsMap.get(complement);
                if(list.get(0) == i && list.size() == 1) {
                    continue;
                }
                if(list.size() > 1) {
                    ans[1] = list.get(1);
                } else {
                    ans[1] = list.get(0);
                }
                ans[0] = i;
                break;
            }
        }
        return ans;
    }
}