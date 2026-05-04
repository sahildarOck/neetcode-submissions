class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        int left = 0, right = 0;

        while(right < nums.length) {
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[right]) {
                dq.removeLast();
            }
            
            dq.addLast(right);
            
            if(dq.getFirst() < left) {
                dq.removeFirst();
            }

            if(right + 1 >= k) {
                ans[left] = nums[dq.getFirst()];
                left++;
            }
            right++;
        }

        return ans;
    }
}
