class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        if(nums.length < 4) {
            return ans;
        }

        // Sort the array
        Arrays.sort(nums);

        // -2, -1, 0, 0, 1, 2

        for(int i = 0 ; i < nums.length - 3 ; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for(int j = i + 1 ; j < nums.length - 2 ; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while(left < right) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[left] + (long) nums[right];
                    if(sum == target) {
                        ans.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    } else if(sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                    while(left > j + 1 && left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while(right < nums.length - 1 && left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
         }

        return ans;
    }
}
