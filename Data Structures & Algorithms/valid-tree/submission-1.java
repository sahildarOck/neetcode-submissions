class Solution {
    public boolean validTree(int n, int[][] edges) {
        // all nodes connected
        if(edges.length != n - 1) {
            return false;
        }

        if(n == 1) {
            return true;
        }

        // no cycle

        // create a node map
        Map<Integer, Set<Integer>> nodeMap = new HashMap<>();

        for(int[] edge : edges) {
            nodeMap.computeIfAbsent(edge[0], (k) -> new HashSet<>()).add(edge[1]);
            nodeMap.computeIfAbsent(edge[1], (k) -> new HashSet<>()).add(edge[0]);
        }

        // nodeMap.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] visited = new boolean[n];
        while(!q.isEmpty()) {
            int node = q.remove();
            if(visited[node]) {
                return false;
            }
            for(int neighbour : nodeMap.get(node)) {
                nodeMap.get(neighbour).remove(new Integer(node));
                q.offer(neighbour);
            }
            visited[node] = true;
        }
        return true;
    }
}
