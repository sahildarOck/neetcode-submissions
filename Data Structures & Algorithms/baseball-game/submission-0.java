class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for(String op : operations) {
            if(op.matches("-?\\d+")) {
                st.push(Integer.parseInt(op));
            } else if (op.equals("+")) {
                int last = st.pop();
                int secondLast = st.peek();
                st.push(last);
                st.push(last + secondLast);
            } else if(op.equals("D")) {
                st.push(st.peek() * 2);
            } else {
                st.pop();
            }
        }

        int ans = 0;
        while(!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }
}