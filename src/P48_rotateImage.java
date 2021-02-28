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
}
