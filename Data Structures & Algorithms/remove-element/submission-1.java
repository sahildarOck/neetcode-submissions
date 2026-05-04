class Solution {
    public int removeElement(int[] nums, int val) {
        if(val > 50) {
            return nums.length;
        }
        int[] freq = new int[51];

        for(int num : nums) {
            freq[num]++;
        }

        // Arrays.stream(freq).forEach(f -> System.out.println(f));

        int k = nums.length - freq[val];

        // System.out.println("k: " + k);
        int j = 0;
        for(int i = 0 ; i < 51 ; i++) {
            if(i == val) {
                continue;
            }

            int count = freq[i];
            while(count > 0) {
                nums[j++] = i;
                count--;
            }
        }

        return k;
    }
}