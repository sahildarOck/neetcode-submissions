class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        answer = new ArrayList<>();
        Arrays.sort(candidates);
        populateCombinationSum2Answer(candidates, target, 0, new ArrayList<>());

        return answer;
    }

    private void populateCombinationSum2Answer(int[] candidates, int target, int i, List<Integer> current) {
        if(target == 0) {
            answer.add(new ArrayList<>(current));
            return;
        }

        if(target < 0 || i >= candidates.length) {
            return;
        }

        current.add(candidates[i]);
        populateCombinationSum2Answer(candidates, target - candidates[i], i + 1, current);
        current.remove(current.size() - 1);
        while(i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        populateCombinationSum2Answer(candidates, target, i + 1, current);
    }
}
