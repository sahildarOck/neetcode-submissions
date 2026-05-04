class LRUCache {

    
    private int capacity;
    private Map<Integer, Integer> cacheMap;
    private LinkedList<Integer> cacheList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.cacheList = new LinkedList<>();
    }
    
    public int get(int key) {
        Integer value = cacheMap.get(key);
        if(value == null) {
            return -1;
        }
        cacheList.remove(Integer.valueOf(key));
        cacheList.addFirst(key);

        // System.out.println("get called with: " + key);
        // print();
        return value;
    }
    
    public void put(int key, int value) {
        if(cacheList.size() == capacity && cacheMap.get(key) == null) {
            Integer keyToRemove = cacheList.removeLast();
            cacheMap.remove(keyToRemove);
        }

        cacheMap.put(key, value);
        
        cacheList.remove(Integer.valueOf(key));
        cacheList.addFirst(key);

        // System.out.println("put called with: [" + key + "," + value + "]");
        // print();
    }

    private void print() {
        
        System.out.println("capacity: " + capacity);
        
        System.out.print("cacheList: ");
        cacheList.forEach(key -> System.out.print(key + " "));
        System.out.println();

        System.out.print("cacheMap: ");
        cacheMap.forEach((k, v) -> System.out.print("[" + k + "," + v + "] "));
        System.out.println();
        System.out.println();
    }
}
