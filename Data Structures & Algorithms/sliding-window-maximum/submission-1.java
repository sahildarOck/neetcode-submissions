class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a2[0] - a1[0]);

        for(int i = 0 ; i < k - 1 ; i++) {
            pq.add(new int[] {nums[i], i});
        }

        for(int i = 0 ; i < ans.length ; i++) {
            pq.add(new int[] {nums[i + k - 1], i + k - 1});
            int[] currRemoved = pq.remove();
            while(currRemoved[1] < i) {
                currRemoved = pq.remove();
            }
            if(currRemoved[1] >= i) {
                pq.add(currRemoved);
            }
            ans[i] = currRemoved[0];
        }

        return ans;
    }
}