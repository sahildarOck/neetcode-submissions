class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            int[] longest = getLongest(s, i, i);
            if(longest[1] - longest[0] > end - start) {
                start = longest[0];
                end = longest[1];
            }
            longest = getLongest(s, i, i + 1);
            if(longest[1] - longest[0] > end - start) {
                start = longest[0];
                end = longest[1];
            }
        }
        return s.substring(start, end + 1);
    }

    private int[] getLongest(String s, int left, int right) {
        while(left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[] {left + 1, right - 1};
    }
 }