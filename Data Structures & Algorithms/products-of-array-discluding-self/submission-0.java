class Solution {
    public int[] productExceptSelf(int[] nums) {
        long fullProduct = 1;
        int zeroCount = 0;
        for(int num : nums) {
            if(zeroCount > 1) {
                fullProduct = 0;
                break;
            }
            if(num == 0) {
                zeroCount++;
                continue;
            }
            fullProduct *= num;
        }

        int[] output = new int[nums.length];

        for(int i = 0 ; i < nums.length ; i++) {
            if(zeroCount > 1) {
                output[i] = 0;
                continue;
            }
            if(nums[i] == 0) {
                output[i] = (int) fullProduct;
            } else if(zeroCount > 0) {
                output[i] = 0;
            } else {
                output[i] = (int) (fullProduct / nums[i]);
            }
        }

        return output;
    }
}  
