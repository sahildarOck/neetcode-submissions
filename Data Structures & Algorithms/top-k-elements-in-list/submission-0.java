class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freqList = new List[nums.length + 1];
        for(int i = 0 ; i < freqList.length ; i++) {
            freqList[i] = new ArrayList<>();
        }

        freqMap.forEach((key, value) -> {
            freqList[value].add(key);
        });

        int[] result = new int[k];
        int resultIndex = 0;
        for(int i = nums.length ; i > 0 && resultIndex < k ; i--) {
            for(int num : freqList[i]) {
                result[resultIndex++] = num;
            }
        }

        return result;
    }
}
