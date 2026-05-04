class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> increasingSt = new Stack<>();
        int[] leftStretchIndex = new int[heights.length];
        int[] rightStretchIndex = new int[heights.length];

        for(int i = 0 ; i < heights.length ; i++) {
            leftStretchIndex[i] = 0;
            while(!increasingSt.isEmpty() && heights[increasingSt.peek()] >= heights[i]) {
                increasingSt.pop();
            }
            if(!increasingSt.isEmpty()) {
                leftStretchIndex[i] = increasingSt.peek() + 1;
            }
            increasingSt.push(i);
        }

        increasingSt.clear();
        for(int i = heights.length - 1 ; i >= 0 ; i--) {
            rightStretchIndex[i] = heights.length - 1;
            while(!increasingSt.isEmpty() && heights[increasingSt.peek()] >= heights[i]) {
                increasingSt.pop();
            }
            if(!increasingSt.isEmpty()) {
                rightStretchIndex[i] = increasingSt.peek() - 1;
            }
            increasingSt.push(i);
        }

        // System.out.println();
        // System.out.println(Arrays.toString(leftStretchIndex));
        // System.out.println(Arrays.toString(rightStretchIndex));

        int ans = 0;
        int currentArea;
        for(int i = 0 ; i < heights.length ; i++) {
            currentArea = heights[i] * (rightStretchIndex[i] - leftStretchIndex[i] + 1);
            if(currentArea > ans) {
                ans = currentArea;
            }
        }

        return ans;
    }
}
