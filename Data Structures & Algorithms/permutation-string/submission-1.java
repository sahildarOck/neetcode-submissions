class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int[] s1CharFreq = new int[26];
        int[] s2MinusS1CharFreq = new int[26];
        int totalMatch = 0;

        for(int i = 0 ; i < s1.length() ; i++) {
            s1CharFreq[s1.charAt(i) - 'a']++;
            s2MinusS1CharFreq[s2.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < 26 ; i++) {
            s2MinusS1CharFreq[i] -= s1CharFreq[i];
            if(s2MinusS1CharFreq[i] == 0) {
                totalMatch++;
            }
        }

        // System.out.println("totalMatch: " + totalMatch);

        int left = 0;
        int right = s1.length() - 1;

        while(totalMatch != 26 && right < s2.length() - 1) {
            int charToRemoveIndex = s2.charAt(left++) - 'a';
            if(s2MinusS1CharFreq[charToRemoveIndex] == 0) {
                totalMatch--;
            }
            s2MinusS1CharFreq[charToRemoveIndex]--;
            if(s2MinusS1CharFreq[charToRemoveIndex] == 0) {
                totalMatch++;
            }

            int charToAddIndex = s2.charAt(++right) - 'a';
            if(s2MinusS1CharFreq[charToAddIndex] == 0) {
                totalMatch--;
            }
            s2MinusS1CharFreq[charToAddIndex]++;
            if(s2MinusS1CharFreq[charToAddIndex] == 0) {
                totalMatch++;
            }
            // System.out.println("totalMatch: " + totalMatch);
        }

        return totalMatch == 26;
    }
}
