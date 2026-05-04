class Solution {
    public int lastStoneWeight(int[] stones) {
         PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        Arrays.stream(stones).forEach(stone -> pq.add(stone));

        int heaviestStone;
        int secondHeaviestStone;
        while(pq.size() > 1) {
            heaviestStone = pq.remove();
            secondHeaviestStone = pq.remove();
            if(secondHeaviestStone != heaviestStone) {
                pq.add(heaviestStone - secondHeaviestStone);
            }
        }

        return pq.size() == 0 ? 0 : pq.remove();
    }
}
