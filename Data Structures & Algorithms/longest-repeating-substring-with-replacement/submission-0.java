class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> charFreqMap = new HashMap<>();

        char[] sCharArr = s.toCharArray();
        int maxFreq = 0;

        int left = 0;
        int right = 0;
        char rightChar;
        char leftChar;

        int longest = 0;
        while(right < s.length()) {
            rightChar = sCharArr[right];
            charFreqMap.putIfAbsent(rightChar, 0);
            charFreqMap.put(rightChar, charFreqMap.get((Character) rightChar) + 1);
            if(maxFreq < charFreqMap.get(rightChar)) {
                maxFreq = charFreqMap.get(rightChar);
            }
            if(right - left + 1 - maxFreq <= k) {
                longest = right - left + 1;
            } else {
                leftChar = sCharArr[left];
                charFreqMap.put(leftChar, charFreqMap.get((Character) leftChar) - 1);
                left++;
            }
            right++;
        }
        return longest;
    }
}
