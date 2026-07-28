class Solution {
    public String longestCommonPrefix(String[] strs) {
        String shortestStr = strs[0];
        for(int i = 1 ; i < strs.length ; i++) {
            String currStr = strs[i];
            if(currStr.length() < shortestStr.length()) {
                shortestStr = currStr;
            }
        }

        for(int i = 0 ; i < strs.length ; i++) {
            int longestCommonPrefixIndex = getLongestCommonPrefixIndex(shortestStr, strs[i]);
            if(longestCommonPrefixIndex == -1) {
                return "";
            }
            shortestStr = shortestStr.substring(0, longestCommonPrefixIndex + 1);
        }
        return shortestStr;
    }

    private int getLongestCommonPrefixIndex(String shortStr, String longStr) {
        int i = 0;
        for(; i < shortStr.length() ; i++) {
            if(shortStr.charAt(i) != longStr.charAt(i)) {
                break;
            }
        }
        return i - 1;
    }
}