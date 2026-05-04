class NumMatrix {

    int[][] computed;
    public NumMatrix(int[][] matrix) {
        computed = new int[matrix.length][matrix[0].length];

        computed[0][0] = matrix[0][0];
        for(int i = 0 ; i < computed.length ; i++) {
            for(int j = 0 ; j < computed[i].length ; j++) {
                if(j == 0) {
                    computed[i][j] = matrix[i][j];
                } else {
                    computed[i][j] = computed[i][j - 1] + matrix[i][j];
                }
            }
        }

        // for(int i = 0 ; i < computed.length ; i++) {
        //     for(int j = 0 ; j < computed[i].length ; j++) {
        //         System.out.print(computed[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        for(int i = 1 ; i < computed.length ; i++) {
            for(int j = 0 ; j < computed[i].length ; j++) {
                computed[i][j] = computed[i - 1][j] + computed[i][j];
            }
        }

        // for(int i = 0 ; i < computed.length ; i++) {
        //     for(int j = 0 ; j < computed[i].length ; j++) {
        //         System.out.print(computed[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = computed[row2][col2];
        if(row1 != 0) {
            sum -= computed[row1 - 1][col2];
        }
        if(col1 != 0) {
            sum -= computed[row2][col1 - 1];
        }
        if(row1 != 0 && col1 != 0) {
            sum += computed[row1 - 1][col1 - 1];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */