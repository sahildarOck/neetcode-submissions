class Solution {
    List<List<String>> ans;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();

        populateAnswerList(s, 0, new ArrayList<>());
        return ans;
    }

    private void populateAnswerList(String s, int start, List<String> curr) {
        if(start == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int end = start + 1 ; end <= s.length() ; end++) {
            if(isPalindrome(s, start, end)) {
                curr.add(s.substring(start, end));
                populateAnswerList(s, end, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {


        char[] chArr = s.toCharArray();
        j--;
        while (i < j) {
            if (chArr[i++] != chArr[j--]) {
                return false;
            }
        }
        return true;
    }
}
