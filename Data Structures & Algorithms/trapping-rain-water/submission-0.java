class Solution {
    public int trap(int[] height) {
        int result = 0;

        int left = 0;
        int right = height.length - 1;

        int leftMax = height[0];
        int rightMax = height[height.length - 1];

        while(left <= right) {
            if(leftMax < rightMax) {
                result += Math.max(leftMax- height[left], 0);
                if(leftMax < height[left]) {
                    leftMax = height[left];
                }
                left++;
            } else {
                result += Math.max(rightMax - height[right], 0);
                if(rightMax < height[right]) {
                    rightMax = height[right];
                }
                right--;
            }
        }

        return result;
    }
}
