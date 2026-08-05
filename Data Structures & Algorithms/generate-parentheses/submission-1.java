class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesis(n, n, "", ans);
        return ans;
    }

    private void generateParenthesis(int open, int close, String str, List<String> ans) {
        if(open == 0 && close == 0) {
            ans.add(str);
            return;
        }

        if(open > 0) {
            generateParenthesis(open - 1, close, str + "(", ans);
        }

        if(open < close) {
            generateParenthesis(open, close - 1, str + ")", ans);
        }
    }
}