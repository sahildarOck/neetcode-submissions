class Solution {
    public int appendCharacters(String s, String t) {
         int sIndex = 0;
        int tIndex = 0;

        while(tIndex < t.length()) {
            char currChar = t.charAt(tIndex);

            while(sIndex < s.length() && s.charAt(sIndex) != currChar) {
                sIndex++;
            }
            if(sIndex == s.length()) {
                break;
            }
            tIndex++;
            sIndex++;
        }

        return t.length() - tIndex;
    }
}