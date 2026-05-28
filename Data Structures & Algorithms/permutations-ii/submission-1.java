class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        computePermutations(nums, new ArrayList<>(), new boolean[nums.length], ans);
        return ans;
    }

    private void computePermutations(int[] nums, List<Integer> current, boolean[] visited, List<List<Integer>> ans) {
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            current.add(nums[i]);
            computePermutations(nums, current, visited, ans);
            visited[i] = false;
            current.remove(current.size() - 1);
        }
    }
}