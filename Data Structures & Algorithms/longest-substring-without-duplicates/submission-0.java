class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }

        int ans = 1;
        int left = 0;
        int right = 1;
        int currLen = 1;
        List<Character> charList = new ArrayList<>();
        charList.add(s.charAt(0));
        char rightChar;
        while(right < s.length()) {
            // System.out.println();
            // charList.forEach(System.out::print);
            // System.out.println();
            // System.out.println("left: " + left);
            // System.out.println("right: " + right);
            rightChar = s.charAt(right);
            if(charList.contains(rightChar)) {
                while(s.charAt(left) != rightChar) {
                    charList.remove((Character)s.charAt(left));
                    left++;
                    currLen--;
                }
                charList.remove((Character)s.charAt(left));
                left++;
                currLen--;
            } else {
                charList.add(rightChar);
                currLen++;
                right++;
            }
            if(ans < currLen) {
                ans = currLen;
            }
        }

        return ans;
    }
}
