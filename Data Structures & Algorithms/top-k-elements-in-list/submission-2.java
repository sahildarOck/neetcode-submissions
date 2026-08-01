class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new TreeMap<>();
        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freq = new List[nums.length + 1];

        for(int i = 0 ; i < nums.length + 1 ; i++) {
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
            int index = e.getValue();
            freq[index].add(e.getKey());
        }

        int[] ans = new int[k];

        int i = 0;
        for(int j = nums.length ; j > -1 && i < k ; j--) {
            for(int num : freq[j]) {
                ans[i] = num;
                i++;
                if(i == k) {
                    return ans;
                }
            }
        }

        return ans;
    }
}