class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Character>[] verticals = new List[9];
        List<Character>[] horizontals = new List[9];
        List<Character>[] boxes = new List[9];

        for(int i = 0 ; i < 9 ; i++) {
            verticals[i] = new ArrayList<>();
            horizontals[i] = new ArrayList<>();
            boxes[i] = new ArrayList<>();
        }

        char currentChar;
        for(int i = 0 ; i < 9 ; i++) {
            for(int j = 0 ; j < 9 ; j++) {
                currentChar = board[i][j];
                if(currentChar == '.') {
                    continue;
                }
                if(verticals[j].contains(currentChar) || 
                horizontals[i].contains(currentChar) ||
                boxes[getBoxIndex(i, j)].contains(currentChar)) {
                    return false;
                } else {
                    verticals[j].add(currentChar);
                    horizontals[i].add(currentChar);
                    boxes[getBoxIndex(i, j)].add(currentChar);
                }
            }
        }
        return true;
    }

    private int getBoxIndex(int i, int j) {
        return (i / 3) * 3 + (j / 3);
    }
}
