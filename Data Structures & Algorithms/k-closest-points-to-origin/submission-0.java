class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (arr1, arr2) -> ((arr2[0] * arr2[0]) + (arr2[1] * arr2[1])) - ((arr1[0] * arr1[0]) + (arr1[1] * arr1[1]))
        );

        for(int i = 0 ; i < points.length ; i++) {
            pq.add(points[i]);

            if(pq.size() > k) {
                pq.remove();
            }
        }

        return pq.toArray(new int[pq.size()][]);

    }
}
