public class P59_spiralMatrixII {
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            int[] dx = new int[]{0, 1, 0, -1};
            int[] dy = new int[]{1, 0, -1, 0};
            int d = 0;
            int x = 0;
            int y = 0;
            for(int i = 0; i < n*n; i++){
                res[x][y] = i+1;
                int tempX = x + dx[d];
                int tempY = y + dy[d];
                if(tempX < 0 || tempX >= n || tempY < 0 || tempY >= n || (res[tempX][tempY] < i+2 && res[tempX][tempY] != 0)) {
                    d = (d + 1) % 4;
                    tempX = x + dx[d];
                    tempY = y + dy[d];
                }
                x = tempX;
                y = tempY;
            }
            return res;
        }
    }
}
