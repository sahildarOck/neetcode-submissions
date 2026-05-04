class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Set<Integer> numsSet = new HashSet<>();
        for(int num : nums) {
            numsSet.add(num);
        }

        int longestConsecutive = 0;
        int currentStreak = 0;
        for(int num : numsSet) {
            if (!numsSet.contains(num - 1)) {
                currentStreak = 1;
                while (numsSet.contains(num + currentStreak)) {
                    currentStreak++;
                }
                longestConsecutive = Math.max(longestConsecutive, currentStreak);
            }
        }

        return longestConsecutive;
    }
}
