class Solution {
    public int tribonacci(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        if(n == 2) {
            return 1;
        }

        int tn = 0;
        int tnPlusOne = 1;
        int tnPlusTwo = 1;
        int tnPlusThree = 2;

        for(int i = 3 ; i <= n ; i++) {
            tnPlusThree = tn + tnPlusOne + tnPlusTwo;
            tn = tnPlusOne;
            tnPlusOne = tnPlusTwo;
            tnPlusTwo = tnPlusThree;
        }

        return tnPlusThree;
    }
}