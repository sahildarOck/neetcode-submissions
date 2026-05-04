class Solution {
    public void sortColors(int[] nums) {
        int[] freqArr = new int[3];

        for(int num : nums) {
            freqArr[num]++;
        }

        int index = 0;
        for(int i = 0 ; i < 3 ; i++) {
            int freq = freqArr[i];
            for(int j = 0 ; j < freq ; j++) {
                nums[index++] = i;
            }
        }
    }
}