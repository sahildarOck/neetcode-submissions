class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int asteroid : asteroids) {
            if(st.isEmpty() || asteroid > 0 || st.peek() < 0) {
                st.push(asteroid);
            } else {
                while(!st.isEmpty() && st.peek() > 0 && Math.abs(asteroid) > st.peek()) {
                    st.pop();
                }
                if(st.isEmpty() || st.peek() < 0) {
                    st.push(asteroid);
                } else if(st.peek() == Math.abs(asteroid)) {
                    st.pop();
                }
            }
        }

        return st.stream().mapToInt(Integer::intValue).toArray();
    }
}