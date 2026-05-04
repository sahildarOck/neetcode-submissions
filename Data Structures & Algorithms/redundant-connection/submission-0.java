class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        for(int i = 1 ; i < n + 1 ; i++) {
            parent[i] = i;
        }

        for(int[] edge : edges) {
            int uRoot = find(edge[0], parent);
            int vRoot = find(edge[1], parent);

            if(uRoot == vRoot) {
                return edge;
            }

            parent[uRoot] = vRoot;
        }

        return new int[0];
    }

    private int find(int node, int[] parent) {
        if(parent[node] != node) {
            parent[node] = find(parent[node], parent);
        }

        return parent[node];
    }
}