class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<int[]> pacific = new LinkedList<>();
        Queue<int[]> atlantic = new LinkedList<>();

        int m = heights.length;
        int n = heights[0].length;

        for(int i = 0 ; i < m; i++) {
            pacific.offer(new int[]{i, 0});
            atlantic.offer(new int[]{i, n - 1});
        }

        for(int j = 0 ; j < n ; j++) {
            pacific.offer(new int[]{0, j});
            atlantic.offer(new int[]{m - 1, j});
        }

        boolean[][] canReachPacific = new boolean[m][n];
        boolean[][] canReachAtlantic = new boolean[m][n];

        bfs(heights, pacific, canReachPacific, m, n);
        bfs(heights, atlantic, canReachAtlantic, m, n);

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(canReachPacific[i][j] && canReachAtlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private final int[][] directions = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    private void bfs(int[][] heights, Queue<int[]> q, boolean[][] canReach, int m, int n) {
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int x = node[0];
            int y = node[1];
            canReach[x][y] = true;

            for(int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n || canReach[nx][ny] || heights[nx][ny] < heights[x][y]) {
                    continue;
                }

                q.offer(new int[]{nx, ny});
            }
        }
    }
}