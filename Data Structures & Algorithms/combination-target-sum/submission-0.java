class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        populateList(candidates, target, 0, list, answer);

        return answer;
    }

    private void populateList(int[] candidates, int target, int i, List<Integer> list, List<List<Integer>> answer) {
        if (target == 0) {
            answer.add(new ArrayList<>(list));
            return;
        }

        if (target < 0 || i >= candidates.length) {
            return;
        }

        list.add(candidates[i]);
        populateList(candidates, target - candidates[i], i, list, answer);
        list.remove(list.size() - 1);
        populateList(candidates, target, i + 1, list, answer);
    }
}
