class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0 ; i <= nums.length ; i++) {
            backtracking(nums, i, 0, new ArrayList<>(), ans);
        }
        return ans;
    }

    private void backtracking(int[] nums, int expectedSize, int index, List<Integer> current, List<List<Integer>> ans) {
        if(current.size() == expectedSize) {
            ans.add(new ArrayList<>(current));
            return;
        }
        if(index == nums.length) {
            return;
        }
        current.add(nums[index]);
        backtracking(nums, expectedSize, index + 1, current, ans);
        current.remove(current.size() - 1);
        backtracking(nums, expectedSize, index + 1, current, ans);
    }
}