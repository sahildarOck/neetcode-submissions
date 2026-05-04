class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack();

        int operand1, operand2;
        int result = 0;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    operand2 = st.pop();
                    operand1 = st.pop();
                    result = operand1 + operand2;
                    st.push(result);
                    break;
                case "-":
                    operand2 = st.pop();
                    operand1 = st.pop();
                    result = operand1 - operand2;
                    st.push(result);
                    break;
                case "*":
                    operand2 = st.pop();
                    operand1 = st.pop();
                    result = operand1 * operand2;
                    st.push(result);
                    break;
                case "/":
                    operand2 = st.pop();
                    operand1 = st.pop();
                    result = operand1 / operand2;
                    st.push(result);
                    break;
                default:
                    st.push(Integer.parseInt(token));

            }
        }
        return st.pop();
    }

    private boolean isOperator(String s) {
        return s.matches("[*/+-]");
    }
}
