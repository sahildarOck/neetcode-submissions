class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();

        int index;
        for(int i = 0 ; i < temperatures.length ; i++) {
            if(st.isEmpty() || temperatures[st.peek()] > temperatures[i]) {
                st.push(i);
            } else {
                while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                    index = st.pop();
                    answer[index] = i - index;
                }
                st.push(i);
            }
        }

        return answer;
    }
}
