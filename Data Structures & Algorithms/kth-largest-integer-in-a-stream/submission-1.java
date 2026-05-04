class KthLargest {

     private int k;
    Queue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        int i;
        for (i = 0; i < k && i < nums.length; i++) {
            pq.add(nums[i]);
        }

        for (; i < nums.length; i++) {
            pq.add(nums[i]);
            pq.remove();
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) {
            pq.remove();
        }
        return pq.peek();
    }
}
