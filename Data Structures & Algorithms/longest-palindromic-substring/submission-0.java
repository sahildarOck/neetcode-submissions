class Solution {
    public String longestPalindrome(String s) {
        for(int i = 0 ; i < s.length() ; i++) {
            int front = i;
            int rear = s.length() - 1;

            while(front > -1) {
                String currStr = s.substring(front, rear + 1);
                if(isPalindrome(currStr)) {
                    return currStr;
                }
                front--;
                rear--;
            }
        }
        return "";
    }

    private boolean isPalindrome(String str) {
        int front = 0;
        int rear = str.length() - 1;

        while(front < rear) {
            if(str.charAt(front) != str.charAt(rear)) {
                return false;
            }
            front++;
            rear--;
        }

        // System.out.println(str + " isPalindrome: " + (front == rear));
        return true;
    }
}
