class Solution {
    public String decodeString(String s) {
        // 3[2[c]]
        // number until [
        // push number
        
        // after [, it can be number or chars
        // chars until ]
        // pop last number
        // push string x number times

        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder currStringBuilder = new StringBuilder();
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            char currCh = s.charAt(i);
            if(Character.isDigit(currCh)) {
                count = (10 * count) + (currCh - '0');
            } else if (currCh == '[') {
                countStack.push(count);
                stringStack.push(currStringBuilder);
                count = 0;
                currStringBuilder = new StringBuilder();
            } else if(Character.isLetter(currCh)) {
                currStringBuilder.append(currCh);
            } else {
                int repeat = countStack.pop();
                StringBuilder prevStringBuilder = stringStack.pop();
                for(int j = 0 ; j < repeat ; j++) {
                    prevStringBuilder.append(currStringBuilder);
                }
                currStringBuilder = prevStringBuilder;
            }
        }
        return currStringBuilder.toString();
    }

}