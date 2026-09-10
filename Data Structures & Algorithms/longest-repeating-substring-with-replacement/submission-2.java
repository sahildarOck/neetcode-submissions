class Solution {
    public int characterReplacement(String s, int k) {
        // AABCA
        // k = 1
        int[] freq = new int[26];

        int left = 0;
        int right = 0;

        int longest = 1;
        int maxFreq = 1;
        int size = 1;
        Arrays.fill(freq, 0);
        freq[s.charAt(0) - 'A']++;

        while (right < s.length() && left <= right) { // review this
            size = right - left + 1;
            if (size - maxFreq <= k) {
                right++;
                longest = Math.max(longest, size);
                if (right < s.length()) {
                    freq[s.charAt(right) - 'A']++;
                    maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
                }
            } else {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
        }
        return longest;
    }
}