class Solution {
    public int[] getConcatenation(int[] nums) {
        int doubleN = 2 * nums.length;
       int[] ans = new int[doubleN];

        int i;
       for(i = 0 ; i < nums.length ; i++) {
        ans[i] = nums[i];
       }

        int j = 0;
       for(i = nums.length ; i < doubleN ; i++) {
        ans[i] = nums[j++];
       }

       return ans;
    }
}