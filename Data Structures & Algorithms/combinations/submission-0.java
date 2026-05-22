class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++) {
            if(n - i + 1 < k) {
                break;
            }
            List<Integer> list = new ArrayList<>();
            list.add(i);
            combine(i + 1, n, k, list, ans);
        }
        return ans;
    }

    private void combine(int i, int n, int k, List<Integer> list, List<List<Integer>> ans) {
        if(list.size() == k) {
            ans.add(list);
            return;
        }
        if(i > n) {
            return;
        }
        List<Integer> newList1 = new ArrayList<>(list);
        newList1.add(i);
        combine(i + 1, n, k, newList1, ans);
        List<Integer> newList2 = new ArrayList<>(list);
        combine(i + 1, n, k, newList2, ans);
    }
}