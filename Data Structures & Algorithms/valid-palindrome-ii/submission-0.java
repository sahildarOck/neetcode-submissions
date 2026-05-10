class Solution {
    public boolean validPalindrome(String s) {
        int front = 0;
        int rear = s.length() - 1;
        boolean discardedSecond = false;

        while(front < rear) {
            if(s.charAt(front) != s.charAt(rear)) {
                break;
            }
            front++;
            rear--;
        }

        if(front == rear) {
            return true;
        }

        int tempFront = front;
        int tempRear = rear - 1;

        front++;
        while(front < rear) {
            if(s.charAt(front) != s.charAt(rear)) {
                discardedSecond = true;
                break;
            }
            front++;
            rear--;
        }

        if(!discardedSecond) {
            return true;
        }

        while(tempFront < tempRear) {
            if(s.charAt(tempFront) != s.charAt(tempRear)) {
                return false;
            }
            tempFront++;
            tempRear--;
        }

        return true;
    }
}