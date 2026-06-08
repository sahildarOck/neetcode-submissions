class Solution {
    public String longestPalindrome(String s) {
        for(int i = 0 ; i < s.length() ; i++) {
            int start = i;
            for(int end = s.length() - 1 ; start > -1 ; start--, end--) {
                if(isPalindrome(s, start, end)) {
                    return s.substring(start, end + 1);
                }
            }
        }
        return "";
    }

    private boolean isPalindrome(String str, int start, int end) {
        while(start < end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
 }