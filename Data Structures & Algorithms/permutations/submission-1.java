class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        computePermutations(nums, new boolean[nums.length], new ArrayList<>(), ans);
        return ans;
    }

    private void computePermutations(int[] nums, boolean[] visited, List<Integer> current,
            List<List<Integer>> ans) {
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            current.add(nums[i]);
            computePermutations(nums, visited, current, ans);
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}