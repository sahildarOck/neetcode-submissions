class Solution {
    public boolean isHappy(int n) {
        // 2, 4, 16, 37, 58, 89, 145, 42, 20, 4
        Set<Integer> squaresSet = new HashSet<>();

        int num = n;
        while(true) {
            squaresSet.add(num);
            num = getSumOfSquares(num);
            if(num == 1) {
                return true;
            }
            if(squaresSet.contains(num)) {
                return false;
            }
        }
        // return false;
    }

    private int getSumOfSquares(int n) {
        int ans = 0;
        // 123
        int lastDigit;
        while(n != 0) {
            lastDigit = n % 10;
            ans += lastDigit * lastDigit;
            n /= 10;
        }

        return ans;
    }
}