class Solution {
    public boolean isSubsequence(String s, String t) {
         int sIndex = 0;
        int tIndex = 0;

        while(sIndex < s.length()) {
            char currChar = s.charAt(sIndex);
            while(tIndex < t.length() && t.charAt(tIndex) != currChar) {
                tIndex++;
            }
            if(tIndex == t.length()) {
                return false;
            }
            tIndex++;
            sIndex++;
        }
        return true;
    }
}