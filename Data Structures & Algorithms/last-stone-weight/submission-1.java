class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> j - i);

        for(int i = 0 ; i < stones.length ; i++) {
            pq.add(stones[i]);
        }

        int heaviest;
        int secondHeaviest;
        int diff;
        while(pq.size() > 1) {
            heaviest = pq.remove();
            secondHeaviest = pq.remove();
            diff = heaviest - secondHeaviest;
            if(diff > 0) {
                pq.offer(diff);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}