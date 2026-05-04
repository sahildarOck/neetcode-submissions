class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();

        for(int i = 0 ; i < nums.length ; i++) {
            numsSet.add(nums[i]);
        }

        int longestConsecutive = 0;

        for(int i = 0 ; i < nums.length ; i++) {
            if(longestConsecutive > nums.length / 2) {
                break;
            }
            int num = nums[i];
            if(numsSet.contains(num - 1)) {
                continue;
            }

            while(numsSet.contains(++num));
            longestConsecutive = Math.max(longestConsecutive, num - nums[i]);
        }

        return longestConsecutive;
    }
}