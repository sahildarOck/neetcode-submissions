class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = 0;

        int[] s1Freq = new int[26];
        char[] s1CharArray = s1.toCharArray();
        for(char c : s1CharArray) {
            s1Freq[c - 'a']++;
        }

        int[] s2Freq = new int[26];
        char rightChar;
        char leftChar;
        while(right < s2.length()) {
            rightChar = s2.charAt(right);
            if(s2Freq[rightChar - 'a'] < s1Freq[rightChar - 'a']) {
                s2Freq[rightChar - 'a']++;
            } else {
                if(areEqual(s1Freq, s2Freq)) {
                    return true;
                }
                if(s1Freq[rightChar - 'a'] == 0) {
                    left = right + 1;
                    Arrays.fill(s2Freq, 0);
                } else {
                    while(s2.charAt(left) != rightChar) {
                        s2Freq[s2.charAt(left) - 'a']--;
                        left++;
                    }
                    left++;
                }
            }
            right++;
        }

        return areEqual(s1Freq, s2Freq);
    }

    private boolean areEqual(int[] c1, int[] c2) {
        // System.out.println("Printing c1:");
        // for(int c : c1) {
        //     System.out.print(c);
        // }
        // System.out.println();
        // System.out.println("Printing c2:");
        // for(int c : c2) {
        //     System.out.print(c);
        // }
        // System.out.println();
        return Arrays.equals(c1, c2);
    }
}
