class Solution {
     List<List<Integer>> subsets;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        subsets = new ArrayList<>();
        Arrays.sort(nums);
        subsets.add(new ArrayList<>());
        populateSubsets(nums, 0, new ArrayList<>());

        return subsets;
    }

    private void populateSubsets(int[] nums, int i, List<Integer> curr) {
        if(i >= nums.length) {
            return;
        }
        curr.add(nums[i]);
        populateSubsets(nums, i + 1, curr);
        subsets.add(new ArrayList<>(curr));
        curr.remove(curr.size() - 1);
        while(i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        populateSubsets(nums, i + 1, curr);
    }
}
