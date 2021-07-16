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
}
