public class P329_longestIncreasingPathInaMatrix {

    /**
     *  brute force approach
     */
    class Solution {
        int max = 0;
        List<Integer> list = new ArrayList<>();
        public int longestIncreasingPath(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    dfs(matrix, i, j);
                }
            }
            return max;
        }

        private void dfs(int[][] matrix, int i, int j) {
            if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
                return;
            }
            if(list.size() != 0 && matrix[i][j] <= list.get(list.size() - 1)) {
                return;
            }
            list.add(matrix[i][j]);
            max = Math.max(list.size(), max);
            dfs(matrix, i - 1, j);
            dfs(matrix, i + 1, j);
            dfs(matrix, i, j - 1);
            dfs(matrix, i, j + 1);
            list.remove(list.size()-1);
            return;
        }
    }


    /**
     * optimal dfs added
     */
    class Solution {
        int[][] flag;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int row;
        int col;
        public int longestIncreasingPath(int[][] matrix) {
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
            row = matrix.length;
            col = matrix[0].length;
            flag = new int[row][col];
            int ans = 0;
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    ans = Math.max(ans, dfs(matrix, i, j));
                }
            }
            return ans;
        }

        private int dfs(int[][] matrix, int i, int j) {
            if(flag[i][j] != 0) {
                return flag[i][j];
            }
            flag[i][j]++;
            for(int[] dir: dirs) {
                int newRow = i + dir[0];
                int newCol = j + dir[1];
                if(newCol >= 0 && newRow >= 0 && newRow < row && newCol < col && matrix[newRow][newCol] > matrix[i][j]) {
                    flag[i][j] = Math.max(flag[i][j], dfs(matrix, newRow, newCol) + 1);
                }
            }
            return flag[i][j];
        }
    }
}
