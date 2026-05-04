class Solution {
    public int orangesRotting(int[][] grid) {
        int minNumberOfMins = 0;
        Queue<int[]> q = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;

        int freshCount = 0;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                if(grid[i][j] == 1) {
                    freshCount += 1;
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()) {
            int qSize = q.size();
            for(int k = 0; k < qSize ; k++) {
                int[] pos = q.poll();

                for(int[] dir : directions) {
                    int nx = pos[0] + dir[0];
                    int ny = pos[1] + dir[1];

                    if(nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] == 0 || grid[nx][ny] == 2) {
                        continue;
                    }
                    grid[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                    freshCount -= 1;
                }
            }

            if(!q.isEmpty()) {
                minNumberOfMins += 1;
            }
        }

        if(freshCount != 0) {
            return -1;
        }

        return minNumberOfMins;
    }

    // private boolean cannotBeRotten(int i, int j, int[][] grid) {
    //     // i and j will be valid
    //     if(grid[i][j] != 1) {
    //         return false;
    //     }

    //     int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    //     for(int[] dir : directions) {
    //         int nx = i + dir[0];
    //         int ny = j + dir[1];

    //         if(nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) {
    //             continue;
    //         }
    //         if(grid[nx][ny] == 2 || grid[nx][ny] == 1) {
    //             return false;
    //         }
    //     }

    //     System.out.print("Returning true!!");

    //     return true;
    // }

    /**
    2 1 1
    0 1 1
    1 0 1
     */
}