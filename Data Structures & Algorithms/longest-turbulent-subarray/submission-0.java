class Solution {
    public int maxTurbulenceSize(int[] arr) {
         if (arr.length == 1) {
            return 1;
        }

        int i = 1;
        while (i < arr.length && arr[i] == arr[i - 1]) {
            i++;
        }

        if (i == arr.length) {
            return 1;
        }

        boolean expectedLess = arr[i] < arr[i - 1] ? false : true;
        i++;
        // System.out.println("expectedLess: " + expectedLess);

        int max = 2;
        int currWinSize = 2;
        int prev = arr[i - 1];
        for (; i < arr.length; i++) {
            // System.out.println();
            // System.out.println("arr[i]: " + arr[i]);
            // System.out.println("<<<< Before >>>");
            // System.out.println("expectedLess: " + expectedLess);
            if ((expectedLess && arr[i] < prev) || (!expectedLess && arr[i] > prev)) {
                currWinSize++;
                expectedLess = !expectedLess;
                max = Math.max(max, currWinSize);
            } else {
                max = Math.max(max, currWinSize);
                while (i < arr.length && arr[i] == arr[i - 1]) {
                    i++;
                }
                if(i < arr.length) {
                    expectedLess = arr[i] < arr[i - 1] ? false : true;
                }
                currWinSize = 2;
            }
            if(i < arr.length) {
                prev = arr[i];
            }
            // System.out.println("<<<< After >>>");
            // System.out.println("expectedLess: " + expectedLess);
            // System.out.println("currWinSize: " + currWinSize);
            // System.out.println("max: " + max);
        }
        return max;
    }
}