class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        computePermutations(nums, new ArrayList<>(), new boolean[nums.length], ans);
        return new ArrayList<>(ans);
    }

    private void computePermutations(int[] nums, List<Integer> current, boolean[] visited, Set<List<Integer>> ans) {
        if(current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
        }
        for(int i = 0 ; i < nums.length ; i++) {
            if(visited[i]) {
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