class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // binary search along the vertial
        int rowIndex = getRowIndex(matrix, target, 0, matrix.length - 1);
        // System.out.println("rowIndex: " + rowIndex);
        if(rowIndex == -1) {
            return false;
        }
        // binary search along the row
        return binarySearch(matrix[rowIndex], target, 0, matrix[rowIndex].length - 1);
    }

    private int getRowIndex(int[][] matrix, int target, int start, int end) {
        if(start > end) {
            return -1;
        }

        int mid = end - (end - start) / 2;
        // System.out.println("mid: " + mid);

        // if(mid + 1 == matrix.length || mid - 1 == -1) {
        //     if(matrix[mid][0] >= target && matrix[mid][matrix[mid].length - 1] <= target) {
        //         return mid;
        //     } else {
        //         return -1;
        //     }
        // }

        // System.out.println("matrix[mid][0] : " + matrix[mid][0]);
        // System.out.println("matrix[mid + 1][0] : " + matrix[mid + 1][0]);
        if(matrix[mid][0] <= target && matrix[mid][matrix[mid].length - 1] >= target) {
            return mid;
        }
        if(matrix[mid][0] > target) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }

        return getRowIndex(matrix, target, start, end);
    }

    private boolean binarySearch(int[] arr, int target, int left, int right) {
        if(left > right) {
            return false;
        }

        int mid = right - (right - left) / 2;

        if(arr[mid] == target) {
            return true;
        }

        if(arr[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }

        return binarySearch(arr, target, left, right);
    }
}
