class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;

        // -1 - nowhere, 0 - init, 1 - pacific, 2 - atlantic, 3 - all
        Queue<int[]> pacific = new LinkedList<>();
        Queue<int[]> atlantic = new LinkedList<>();

        boolean [][] pac = new boolean[m][n];
        boolean [][] atl = new boolean[m][n];

        for(int i = 0 ; i < m ; i++) {
            pacific.offer(new int[]{i, 0});
            atlantic.offer(new int[]{i, n - 1});
        }

        for(int i = 0 ; i < n ; i++) {
            pacific.offer(new int[]{0, i});
            atlantic.offer(new int[]{m - 1, i});
        }

        bfs(heights, pac, pacific, m, n);
        bfs(heights, atl, atlantic, m, n);

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(pac[i][j] && atl[i][j]) {
                    ans.add(List.of(i, j));
                }
            }
        }

        return ans;
    }

    private void bfs(int[][] heights, boolean[][] ocean, Queue<int[]> q, int m, int n) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()) {
            int[] index = q.poll();
            int x = index[0];
            int y = index[1];
            ocean[x][y] = true;

            for(int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n || ocean[nx][ny] || heights[nx][ny] < heights[x][y]) {
                    continue;
                }

                q.offer(new int[]{nx, ny});
            }
        }
    }
}