class Solution {
    List<List<Integer>> permutationList;
    public List<List<Integer>> permute(int[] nums) {
        permutationList = new ArrayList<>();

        populateList(nums, new ArrayList<>(), new boolean[nums.length]);

        return permutationList;
    }

    private void populateList(int[] nums, List<Integer> current, boolean[] picked) {
        if(current.size() == nums.length) {
            permutationList.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++) {
            if(!picked[i]) {
                current.add(nums[i]);
                picked[i] = true;
                populateList(nums, current, picked);
                current.remove(current.size() - 1);
                picked[i] = false;
            }
        }
    }
}
