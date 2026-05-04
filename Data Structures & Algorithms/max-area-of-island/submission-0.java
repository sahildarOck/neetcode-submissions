class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        int currArea;
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[0].length ; j++) {
                currArea = getMaxArea(i, j, grid, visited);
                if(currArea > maxArea) {
                    maxArea = currArea;
                }
            }
        }
        return maxArea;
    }

    private int getMaxArea(int i, int j, int[][] grid, boolean[][] visited) {
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + 
        getMaxArea(i + 1, j, grid, visited) + 
        getMaxArea(i - 1, j, grid, visited) +
        getMaxArea(i, j + 1, grid, visited) +
        getMaxArea(i, j - 1, grid, visited);
    }
}
