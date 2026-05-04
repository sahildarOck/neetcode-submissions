class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // freqMap.forEach((key, v) -> System.out.println("Key: " + key + " Value: " + v));

        Map<Integer, List<Integer>> sortedMap = new TreeMap<>(Collections.reverseOrder());
        freqMap.forEach((key, v) -> {
            List<Integer> vals = sortedMap.getOrDefault(v, new ArrayList<>());
            vals.add(key);
            sortedMap.put(v, vals);
        });

        // sortedMap.forEach((key, v) -> System.out.println("Key: " + key + " Value: " + v));

        int[] ans = new int[k];
        int index = 0;

        for(List<Integer> vals : sortedMap.values()) {
            for(int val : vals) {
                ans[index++] = val;
                if(index == k) {
                    return ans;
                }
            }
        }

        return ans;
    }
}