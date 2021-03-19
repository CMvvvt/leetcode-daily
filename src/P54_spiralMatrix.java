public class P54_spiralMatrix {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> list = new ArrayList<Integer>();
            if(matrix == null || matrix.length == 0)
                return list;
            int m = matrix.length;
            int n = matrix[0].length;
            int i = 0;

            //统计矩阵从外向内的层数，如果矩阵非空，那么它的层数至少为1层
            int count = (Math.min(m, n)+1)/2;
            //从外部向内部遍历，逐层打印数据
            while(i < count) {
                for (int j = i; j < n-i; j++) {
                    list.add(matrix[i][j]);
                }
                for (int j = i+1; j < m-i; j++) {
                    list.add(matrix[j][(n-1)-i]);
                }

                for (int j = (n-1)-(i+1); j >= i && (m-1-i != i); j--) {
                    list.add(matrix[(m-1)-i][j]);
                }
                for (int j = (m-1)-(i+1); j >= i+1 && (n-1-i) != i; j--) {
                    list.add(matrix[j][i]);
                }
                i++;
            }
            return list;
        }
    }
//      method 2
//    class Solution {
//        public List<Integer> spiralOrder(int[][] matrix) {
//            List<Integer> res = new ArrayList<Integer>();
//            if(matrix == null || matrix.length == 0){
//                return res;
//            }
//            int m = matrix.length;
//            int n = matrix[0].length;
//            int[] dx = {0, 1, 0, -1};
//            int[] dy = {1, 0, -1, 0};
//            int x = 0;
//            int y = 0;
//            int d = 0;
//            for(int i = 0; i < m*n; i++){
//                res.add(matrix[x][y]);
//                matrix[x][y] = 1000;
//                int tempX = x + dx[d];
//                int tempY = y + dy[d];
//                if(tempX < 0 || tempX >= m || tempY < 0 || tempY >= n || matrix[tempX][tempY] == 1000) {
//                    d = (d + 1) % 4;
//                    tempX = x + dx[d];
//                    tempY = y + dy[d];
//                }
//                x = tempX;
//                y = tempY;
//            }
//            return res;
//        }
//    }
}
