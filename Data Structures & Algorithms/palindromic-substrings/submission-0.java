class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            count += getPalindromeSubstringCountWithCentre(s, i, i);
            count += getPalindromeSubstringCountWithCentre(s, i, i + 1);
        }
        return count;
    }

    private int getPalindromeSubstringCountWithCentre(String s, int start, int end) {
        int count = 0;
        while(start > -1 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            count++;
        }
        return count;
    }
}