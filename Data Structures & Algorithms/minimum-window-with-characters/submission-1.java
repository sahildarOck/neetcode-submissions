class Solution {
    public String minWindow(String s, String t) {
        int[] tFreq = new int[52];
        Arrays.fill(tFreq, 0);

        for (int i = 0; i < t.length(); i++) {
            tFreq[getIndex(t.charAt(i))]++;
        }

        int left = 0;
        int right = 0;
        while (left < s.length() && tFreq[getIndex(s.charAt(left))] == 0) {
            left++;
        }

        if (left == s.length()) {
            return "";
        }
        if(t.length() == 1) {
            return s.charAt(left) + "";
        }
        right = left + 1;
        int lengthMatch = 1;
        int min = Integer.MAX_VALUE;
        int[] sFreq = new int[52];
        Arrays.fill(sFreq, 0);
        sFreq[getIndex(s.charAt(left))]++;
        int rightCharIndex;
        int leftCharIndex = getIndex(s.charAt(left));
        String ans = "";
        while (right < s.length() && left <= right) {
            while (lengthMatch < t.length() && right < s.length()) {
                rightCharIndex = getIndex(s.charAt(right));
                sFreq[rightCharIndex]++;
                if (tFreq[rightCharIndex] >= sFreq[rightCharIndex]) {
                    lengthMatch++;
                }
                right++;
            }
            while (lengthMatch == t.length()) {
                int currLength = right - left;
                if (currLength < min) {
                    min = currLength;
                    ans = s.substring(left, right);
                }
                sFreq[leftCharIndex]--;
                if (sFreq[leftCharIndex] < tFreq[leftCharIndex]) {
                    lengthMatch--;
                }
                left++;
                leftCharIndex = getIndex(s.charAt(left));
            }
        }
        return ans;
    }

    private int getIndex(char c) {
        if (c <= 'Z') {
            return c - 'A';
        }
        return c - 'a' + 26;
    }
}