class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        boolean noFresh = true;
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[i].length ; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if(grid[i][j] == 1) {
                    noFresh = false;
                }
            }
        }

        if(q.isEmpty() && noFresh) {
            return 0;
        }

        if(q.isEmpty() && !noFresh) {
            return -1;
        }

        int[][] offSets = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int minMins = -1;
        while(!q.isEmpty()) {
            int qSize = q.size();
            minMins++;
            for(int i = 0 ; i < qSize ; i++) {
                int[] cell = q.poll();
                for(int[] offSet : offSets) {
                    int nX = cell[0] + offSet[0];
                    int nY = cell[1] + offSet[1];
                    if(nX < 0 || nY < 0 || nX >= grid.length || nY >= grid[0].length) {
                        continue;
                    }
                    if(grid[nX][nY] == 1) {
                        grid[nX][nY] = 2;
                        q.add(new int[]{nX, nY});
                    }
                }
            }
        }

        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[i].length ; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return minMins;
    }
}