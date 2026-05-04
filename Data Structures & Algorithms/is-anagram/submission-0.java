class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] freqS = new int[26];
        int[] freqT = new int[26];
        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();

        for(int i = 0 ; i < sCharArr.length ; i++) {
            freqS[sCharArr[i] - 'a']++;
            freqT[tCharArr[i] - 'a']++;
        }

        for(int i = 0 ; i < 26 ; i++) {
            if(freqS[i] != freqT[i]) {
                return false;
            }
        }

        return true;
    }
}
