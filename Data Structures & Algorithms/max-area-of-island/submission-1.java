class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[i].length ; j++) {
                maxArea = Math.max(maxArea, getMaxArea(grid, visited, i, j));
            }
        }
        return maxArea;
    }

    private int getMaxArea(int[][] grid, boolean[][] visited, int i, int j) {
        if(i < 0 || i >= grid.length 
        || j < 0
        || j >= grid[i].length 
        || visited[i][j]
        || grid[i][j] == 0) {
            return 0;
        }

        visited[i][j] = true;
        return 1 + getMaxArea(grid, visited, i, j - 1)
        + getMaxArea(grid, visited, i - 1, j)
        + getMaxArea(grid, visited, i, j + 1)
        + getMaxArea(grid, visited, i + 1, j);
    }
}