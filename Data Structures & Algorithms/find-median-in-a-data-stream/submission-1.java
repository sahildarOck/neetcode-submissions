class MedianFinder {
private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {

        // 6 10 2 6
        // maxH -> 2 6
        // minH -> 10
        Integer max = null;
        if(!maxHeap.isEmpty()) {
            max = maxHeap.peek();
        }

        if(max == null) {
            maxHeap.add(num);
            return;
        }

        if(max > num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if(minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.remove());
        } else if(maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.remove());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2d;
        }

        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
    }
}
