class StockSpanner {

    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!st.isEmpty()) {
            int[] curr = st.peek();
            if(curr[0] <= price) {
                span += curr[1];
                st.pop();
            } else {
                st.push(new int[] {price, span});
                break;
            }
        }
        if(st.isEmpty()) {
            st.push(new int[] {price, span});
        }
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */