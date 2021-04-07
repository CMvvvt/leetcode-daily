public class P74_search2DMatrix {
    class Solution1 {
        public boolean searchMatrix(int[][] matrix, int target) {
            if(target < matrix[0][0]) {
                return false;
            }
            for(int i = 0; i < matrix.length - 1; i++) {
                if(target >= matrix[i][0] && target < matrix[i+1][0]) {
                    for(int j = 0; j < matrix[0].length; j++){
                        if(target == matrix[i][j]) return true;
                    }
                    return false;
                }
            }
            for(int k = 0; k < matrix[0].length; k++) {
                if(target == matrix[matrix.length-1][k]) return true;
            }
            return false;
        }
    }
// method 2 binary search.
    class Solution2 {
        public boolean searchMatrix(int[][] matrix, int target) {
            int index = binarySearchFirstColumn(matrix, target);
            if(index < 0) {
                return false;
            }
            return binarySearchRow(matrix[index], target);
        }

        public int binarySearchFirstColumn(int[][] matrix, int target) {
            int low = -1, high = matrix.length-1;
            while(low < high) {
                int mid = low + (high - low + 1) / 2;
                if(matrix[mid][0] <= target) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            return low;
        }

        public boolean binarySearchRow(int[] row, int target) {
            int low = 0, high = row.length -1;
            while(low <= high) {
                int mid = low + (high - low) / 2;
                if(row[mid] == target) {
                    return true;
                } else if (row[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return false;
        }
    }
}
