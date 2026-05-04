class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> nodesMap = new HashMap<>();

        for(int[] time : times) {
            nodesMap.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0});

        int[] time = new int[n + 1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k] = 0;

        boolean[] visited = new boolean[n + 1];
        while(!pq.isEmpty()) {
            int[] curr = pq.remove();
            int node = curr[0];
            int timeSoFar = curr[1];

            if(visited[node]) {
                continue;
            }
            visited[node] = true;

            for(int[] neighbour : nodesMap.getOrDefault(node, new ArrayList<>())) {
                int next = neighbour[0];
                int weight = neighbour[1];

                if(!visited[next] && timeSoFar + weight < time[next]) {
                    time[next] = timeSoFar + weight;
                    pq.offer(new int[]{next, time[next]});
                }
            }
        }

        int max = 0;
        for(int i = 1 ; i <= n ; i++) {
            if(time[i] == Integer.MAX_VALUE) {
                return -1;
            }
            if(time[i] > max) {
                max = time[i];
            }
        }
        return max;
    }
}