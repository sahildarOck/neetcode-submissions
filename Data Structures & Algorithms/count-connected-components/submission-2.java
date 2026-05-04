class Solution {
    public int countComponents(int n, int[][] edges) {
        // create a nodeMap
        Map<Integer, Set<Integer>> nodeMap = new HashMap<>();

        for(int[] edge :  edges) {
            nodeMap.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            nodeMap.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int componentsCount = 0;
        // iterate from 0 to n - 1
        for(int i = 0 ; i < n ; i++) {
            if(visited[i]) {
                continue;
            }
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);

            while(!q.isEmpty()) {
                int node = q.remove();
                Set<Integer> neighbours = nodeMap.get(node);
                if(neighbours != null) {
                    for(int neighbour : neighbours) {
                        nodeMap.get(neighbour).remove(new Integer(node));
                        q.offer(neighbour);
                    }
                }
                visited[node] = true;
            }
            componentsCount++;
        }

        return componentsCount;
    }
}
