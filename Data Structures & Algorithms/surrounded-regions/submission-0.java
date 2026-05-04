class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] cantFormRegion = new boolean[m][n];
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i < m ; i++) {
            if(board[i][0] == 'O') {
                cantFormRegion[i][0] = true;
                q.offer(new int[]{i, 0});
            }
            if(board[i][n - 1] == 'O') {
                cantFormRegion[i][n - 1] = true;
                q.offer(new int[]{i, n - 1});
            }
        }

        for(int i = 1 ; i < n - 1 ; i++) {
            if(board[0][i] == 'O') {
                cantFormRegion[0][i] = true;
                q.offer(new int[]{0, i});
            }
            if(board[m - 1][i] == 'O') {
                cantFormRegion[m - 1][i] = true;
                q.offer(new int[]{m - 1, i});
            }
        }

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            visited[x][y] = true;

            for(int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n || board[nx][ny] == 'X' || visited[nx][ny]) {
                    continue;
                }

                cantFormRegion[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(board[i][j] == 'O' && !cantFormRegion[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}