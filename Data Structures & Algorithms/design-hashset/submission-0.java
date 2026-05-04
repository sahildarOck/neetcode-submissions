class MyHashSet {

    LinkedList<Integer>[] buckets;
    public MyHashSet() {
        buckets = new LinkedList[10000];
    }
    
    public void add(int key) {
        LinkedList<Integer> rootBucket = getRootBucket(key);
        if(rootBucket.indexOf(key) == -1) {
            rootBucket.offer(key);
        }
    }
    
    public void remove(int key) {
        LinkedList<Integer> rootBucket = getRootBucket(key);
        rootBucket.remove((Integer) key);
    }
    
    public boolean contains(int key) {
        LinkedList<Integer> rootBucket = getRootBucket(key);
        return rootBucket.indexOf((Integer)key) != -1;
    }

    private LinkedList<Integer> getRootBucket(int key) {
        int bucketIndex = key % 10000;
        if(buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new LinkedList<>();
        }
        return buckets[bucketIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */