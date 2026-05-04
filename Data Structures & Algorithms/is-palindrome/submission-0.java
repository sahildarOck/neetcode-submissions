class Solution {
     public boolean isPalindrome(String s) {
        char[] charArr = s.toLowerCase().toCharArray();

        int front = 0;
        int rear = charArr.length - 1;

        while(front < rear) {
            if(!isValid(charArr[front])) {
                front++;
                continue;
            }
            if(!isValid(charArr[rear])) {
                rear--;
                continue;
            }
            if(charArr[front] != charArr[rear]) {
                return false;
            }
            front++;
            rear--;
        }
        return true;
    }

    private boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
