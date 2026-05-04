class KthLargest {
private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>(k);

        int i;
        for (i = 0 ; i < k && i< nums.length ; i++) {
            pq.add(nums[i]);
        }

        for(; i < nums.length ; i++) {
            pq.add(nums[i]);
            pq.remove();
        }

    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > k) {
            pq.remove();
        }
        return pq.peek();
    }
}
