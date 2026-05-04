class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    Queue<Integer> activeQ;
    Queue<Integer> otherQ;

    // 1 2 3

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        updateQReferences();
        activeQ.offer(x);
    }
    
    public int pop() {
        updateQReferences();
        while(activeQ.size() != 1) {
            otherQ.offer(activeQ.remove());
        }
        return activeQ.remove();
    }
    
    public int top() {
        updateQReferences();
        while(activeQ.size() != 1) {
            otherQ.offer(activeQ.remove());
        }
        int last = activeQ.remove();
        otherQ.offer(last);
        return last;
    }
    
    public boolean empty() {
        updateQReferences();
        return activeQ.isEmpty();
    }

    private void updateQReferences() {
        if(q1.isEmpty()) {
            activeQ = q2;
            otherQ = q1;
        } else {
            activeQ = q1;
            otherQ = q2;
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */