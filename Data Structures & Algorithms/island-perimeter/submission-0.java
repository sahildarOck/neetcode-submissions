class Solution {
    public int islandPerimeter(int[][] grid) {
        // if at the last row/column + if  water on a side
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                ans += getPerimeterCount(i, j, grid);
            }
        }

        return ans;
    }

    private int getPerimeterCount(int i, int j, int[][] grid) {
        if (grid[i][j] == 0) {
            return 0;
        }
        int count = 0;
        if (i == 0) {
            count++;
        } else if ((i - 1) > -1 && grid[i - 1][j] == 0) {
            count++;
        }

        if (i == grid.length - 1) {
            count++;
        } else if ((i + 1) < grid.length && grid[i + 1][j] == 0) {
            count++;
        }

        if (j == 0) {
            count++;
        } else if ((j - 1) > -1 && grid[i][j - 1] == 0) {
            count++;
        }

        if (j == grid[i].length - 1) {
            count++;
        } else if ((j + 1) < grid[i].length && grid[i][j + 1] == 0) {
            count++;
        }

        return count;
    }
}