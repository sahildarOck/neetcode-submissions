class Solution {
     public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans, "", 0, 0, n);
        return ans;
    }

    private void generate(List<String> ans, String combination, int open, int close, int n) {
        if(close > open || close > n || open > n) {
            return;
        }
        if(combination.length() == 2 * n) {
            ans.add(combination);
            return;
        }

        generate(ans, combination + "(", open + 1, close, n);
        generate(ans, combination + ")", open, close + 1, n);
    }
}
