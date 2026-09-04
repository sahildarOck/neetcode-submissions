class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int longestSubstringLength = 1;
        int start = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        charIndexMap.put(s.charAt(0), 0);
        Character currChar;
        for(int i = 1 ; i < s.length() ; i++) {
            currChar = s.charAt(i);
            if(charIndexMap.containsKey(currChar)) {
                int lastIndex = charIndexMap.get(currChar);
                if(lastIndex >= start) {
                    start = lastIndex + 1;
                }
                charIndexMap.remove(new Character(currChar));
            }
            charIndexMap.put(currChar, i);
            longestSubstringLength = Math.max(longestSubstringLength, i - start + 1);
        }
        return longestSubstringLength;
    }
}