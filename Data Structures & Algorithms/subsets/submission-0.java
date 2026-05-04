class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> allSubsets = new ArrayList<>();

        allSubsets.add(new ArrayList<>());

        for (int num : nums) {
            int size = allSubsets.size();
            for(int i = 0 ; i < size ; i++) {
                List<Integer> currentSubset = allSubsets.get(i);
                List<Integer> newSubset = new ArrayList<>(currentSubset);
                newSubset.add(num);
                allSubsets.add(newSubset);
            }
        }

        return allSubsets;
    }
}
