class MyHashMap {

    private int[] vals;
    public MyHashMap() {
        vals = new int[1000001];
        Arrays.fill(vals, -1);
    }
    
    public void put(int key, int value) {
        vals[key] = value;
    }
    
    public int get(int key) {
        return vals[key];
    }
    
    public void remove(int key) {
        vals[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */