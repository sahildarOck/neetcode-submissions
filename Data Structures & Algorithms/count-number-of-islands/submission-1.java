class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islandCount = 0;
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[i].length ; j++) {
                if(grid[i][j] == '0' || visited[i][j]) {
                    continue;
                }
                islandCount++;
                markVisited(grid, visited, i, j);
            }
        }
        return islandCount;
    }

    private void markVisited(char[][] grid, boolean[][] visited, int i, int j) {
        if(i < 0 || i == visited.length
            || j < 0 || j == visited[i].length 
            || grid[i][j] == '0'
            || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        markVisited(grid, visited, i - 1, j);
        markVisited(grid, visited, i, j - 1);
        markVisited(grid, visited, i, j + 1);
        markVisited(grid, visited, i + 1, j);
    }
}