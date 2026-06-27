class Solution {
    public int numDecodings(String s) {
        // Integer[] numWays = new Integer[s.length()];
        // int res = numDecodings(s, 0, numWays);
        // System.out.println(Arrays.toString(numWays));
        // return res;
        return numDecodings(s, 0, new Integer[s.length()]);
    }

    private int numDecodings(String s, int index, Integer[] numWays) {
        if(index >= s.length()) {
            // System.out.println("Inside 1st if");
            // System.out.println("index: " + index);
            return 1;
        }
        if(numWays[index] != null) {
            // System.out.println("Inside 2nd if");
            // System.out.println("index: " + index);
            return numWays[index];
        }

        int curr = Integer.parseInt(String.valueOf(s.charAt(index)));
        if(curr == 0) {
            return 0;
        }
        int ways = numDecodings(s, index + 1, numWays);
        if(curr > 2) {
            // System.out.println("Inside curr > 2 if");
            // System.out.println("index: " + index);
            numWays[index] = ways;
            return ways;
        }
        if(index < s.length() - 1) {
            // System.out.println("Inside index < s.length() - 1 if");
            // System.out.println("index: " + index);
            int next = Integer.parseInt(String.valueOf(s.charAt(index + 1)));
            if(curr == 1 || next < 7) {
                // System.out.println("Inside curr == 1 || next < 7 if");
                // System.out.println("index: " + index);
                ways += numDecodings(s, index + 2, numWays);
            }
        }
        numWays[index] = ways;
        return ways;
    }
}