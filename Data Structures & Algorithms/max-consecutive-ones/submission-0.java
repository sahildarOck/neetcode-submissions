class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curr = 0;
        for (int num : nums) {
            if (num == 0) {
                if (curr > max) {
                    max = curr;
                }
                curr = 0;
            } else {
                curr++;
            }
        }
        if (curr > max) {
            max = curr;
        }
        return max;
    }
}