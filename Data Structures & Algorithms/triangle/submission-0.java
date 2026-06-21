class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> minPathSum = new ArrayList<>();
        List<Integer> first = new ArrayList<>(triangle.get(0));

        minPathSum.add(first);

        List<Integer> prev = first;
        for(int i = 1 ; i < triangle.size() ; i++) {
            List<Integer> triangleList = triangle.get(i);
            List<Integer> curr = new ArrayList<>();
            curr.add(triangleList.get(0) + prev.get(0));
            int j;
            for(j = 1 ; j < triangleList.size() - 1 ; j++) {
                curr.add(Math.min(prev.get(j - 1), prev.get(j)) + triangleList.get(j));
            }
            curr.add(triangleList.get(j) + prev.get(j - 1));
            minPathSum.add(curr);
            prev = curr;
        }

        int minTotal = Integer.MAX_VALUE;
        for(int i = 0 ; i < prev.size() ; i++) {
            minTotal = Math.min(minTotal, prev.get(i));
        }

        // minPathSum.forEach(list -> System.out.println(list));

        return minTotal;
    }
}