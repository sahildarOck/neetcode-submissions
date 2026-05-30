class StockSpanner {

    // private Stack<Integer> st;
    private List<Integer> list;

    public StockSpanner() {
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        int index = list.size() - 1;
        while(index > -1 && list.get(index) <= price) {
            index--;
        }
        list.add(price);
        return list.size() - 1 - index;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */