class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num : nums) {
            freqMap.putIfAbsent(num, 0);
            freqMap.put(num, freqMap.get(num) + 1);
        }

        List<Integer> ans = new ArrayList<>();

        int nBy3 = nums.length / 3;
        freqMap.forEach((k, v) -> {
            if(v > nBy3) {
                ans.add(k);
            }
        });

        return ans;
    }
}