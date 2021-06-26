public class P48_rotateImage {
    /**
     * 暴力解法
     * 时间/空间复杂度 N^2
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int[][] temp = new int[len][len];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j <len; j++) {
                temp[i][j] = matrix[i][j];
            }
        }

        for(int i = 0; i < len; i++) {
            for(int j = 0; j <len; j++) {
                matrix[i][j] = temp[len - 1 -j][i];
            }
        }
    }

    /**
     * in-place method added
     */
    class Solution2 {
        public void rotate(int[][] matrix) {
            transpose(matrix);
            reflect(matrix);
        }

        private void transpose(int[][] matrix) {
            int n = matrix.length;
            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j < n; j++) {
                    int temp = matrix[j][i];
                    matrix[j][i] = matrix[i][j];
                    matrix[i][j] = temp;
                }
            }
        }

        private void reflect(int[][] matrix) {
            int n = matrix.length;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n / 2; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][n-j-1];
                    matrix[i][n-j-1] = temp;
                }
            }
        }
    }
}
