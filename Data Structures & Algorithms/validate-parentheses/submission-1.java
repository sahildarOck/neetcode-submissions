class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++) {
            char curr = s.charAt(i);
            switch(curr) {
                case '(':
                case '[':
                case '{':
                    st.push(curr);
                    break;
                case ')':
                    if(st.isEmpty() || st.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if(st.isEmpty() || st.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if(st.isEmpty() || st.pop() != '{') {
                        return false;
                    }
                    break;
            }
        }
        return st.isEmpty();
    }
}