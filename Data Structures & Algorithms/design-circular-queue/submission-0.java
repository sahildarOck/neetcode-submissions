class MyCircularQueue {

    LinkedList<Integer> cQ;
    int k;

    public MyCircularQueue(int k) {
        cQ = new LinkedList<>();
        this.k = k;
    }
    
    public boolean enQueue(int value) {
        if(cQ.size() == k) {
            return false;
        }
        return cQ.offer(value);
    }
    
    public boolean deQueue() {
        return cQ.pollFirst() != null;
    }
    
    public int Front() {
        Integer front = cQ.peekFirst();
        return front == null ? -1 : front;
    }
    
    public int Rear() {
        Integer rear = cQ.peekLast();
        return rear == null ? -1 : rear;
    }
    
    public boolean isEmpty() {
        return cQ.isEmpty();
    }
    
    public boolean isFull() {
        return cQ.size() == k;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */