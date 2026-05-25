class Solution {
    public int[] plusOne(int[] digits) {
        int[] ans;
        boolean allNines = true;
        for(int digit : digits) {
            if(digit != 9) {
                allNines = false;
                break;
            }
        }
        if(allNines) {
            ans = new int[digits.length + 1];
            ans[0] = 1;
            for(int i = 1 ; i < ans.length ; i++) {
                ans[i] = 0;
            }
            return ans;
        }

        int i = digits.length - 1;
        ans = new int[digits.length];
        while(digits[i] == 9) {
            ans[i] = 0;
            i--;
        }
        ans[i] = digits[i] + 1;
        i--;

        while(i >= 0) {
            ans[i] = digits[i];
            i--;
        }
        return ans;  
    }
}