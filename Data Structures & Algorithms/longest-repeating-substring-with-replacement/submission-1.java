class Solution {
    public int characterReplacement(String s, int k) {
        int[] charFreq = new int[26];

        char[] sCharArr = s.toCharArray();
        int maxFreq = 0;

        int left = 0;
        int right = 0;
        char rightChar;
        char leftChar;

        int longest = 0;
        while(right < s.length()) {
            rightChar = sCharArr[right];
            charFreq[rightChar - 'A']++;
            if(maxFreq < charFreq[rightChar - 'A']) {
                maxFreq = charFreq[rightChar - 'A'];
            }
            if(right - left + 1 - maxFreq <= k) {
                longest = right - left + 1;
            } else {
                leftChar = sCharArr[left];
                charFreq[leftChar - 'A']--;
                left++;
            }
            right++;
        }
        return longest;
    }
}
