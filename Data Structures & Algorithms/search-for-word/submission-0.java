class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[i].length ; j++) {
                if(exist(board, i, j, word, 0, new boolean[board.length][board[i].length])) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, int i, int j, String word, int matchCount, boolean[][] visited) {
        if(word.length() == matchCount) {
            return true;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[i].length || visited[i][j]) {
            return false;
        }

        if(board[i][j] != word.charAt(matchCount)) {
            return false;
        }
        visited[i][j] = true;

        // System.out.println("i: " + i + " & j: " + j);
        // System.out.println("Comparing: board[i][j]: " + board[i][j] + " & word.charAt(matchCount): " + word.charAt(matchCount));
        // printArray(visited);
        // System.out.println();

        matchCount++;

        boolean found = exist(board, i, j + 1, word, matchCount, visited) || 
        exist(board, i + 1, j, word, matchCount, visited) || 
        exist(board, i - 1, j, word, matchCount, visited) ||
        exist(board, i, j - 1, word, matchCount, visited);

        visited[i][j] = false;
        return found;
    }

    private void printArray(boolean[][] visited) {
        Arrays.stream(visited).forEach(arr -> {
            for(int i = 0 ; i < arr.length ; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        });
    }
}
