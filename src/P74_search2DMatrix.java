public class P74_search2DMatrix {
    class Solution {
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
}
