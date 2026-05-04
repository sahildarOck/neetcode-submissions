class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();

        char lastChar;
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else if(st.isEmpty()) {
                return false;
            } else {
                lastChar = st.peek();
                if((c == ')' && lastChar != '(') 
                || (c == '}' && lastChar != '{')
                || (c == ']' && lastChar != '[')) {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        return st.size() == 0;
    }
}
