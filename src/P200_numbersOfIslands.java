public class P200_numbersOfIslands {
    class Solution {
        public int numIslands(char[][] grid) {
            if(grid == null || grid.length == 0) return 0;
            int m = grid.length, n = grid[0].length;
            int count = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == '1') {
                        count++;
                        dfs(grid, i, j);
                    }
                }
            }
            return count;
        }
        private void dfs(char[][] grid, int i, int j) {
            int m = grid.length;
            int n = grid[0].length;
            if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';
            dfs(grid, i+1, j);
            dfs(grid, i-1, j);
            dfs(grid, i, j+1);
            dfs(grid, i, j-1);
        }
    }

    class Solution2 {
        public int numIslands(char[][] grid) {
            if(grid == null || grid.length == 0) return 0;
            int m = grid.length, n = grid[0].length;
            int count = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == '1') {
                        count++;
                        grid[i][j] = '0';
                        Queue<Integer> queue = new LinkedList<>();
                        queue.add(i * n + j);
                        while(! queue.isEmpty()){
                            int id = queue.remove();
                            int row = id / n;
                            int col = id % n;
                            if(row-1 >= 0 && grid[row-1][col] == '1') {
                                grid[row-1][col] = '0';
                                queue.add((row-1)*n + col);
                            }
                            if(row+1 < m && grid[row+1][col] == '1') {
                                grid[row+1][col] = '0';
                                queue.add((row+1)*n + col);
                            }
                            if(col+1 < n && grid[row][col+1] == '1') {
                                grid[row][col+1] = '0';
                                queue.add((row)*n + col+1);
                            }
                            if(col-1 >= 0 && grid[row][col-1] == '1') {
                                grid[row][col-1] = '0';
                                queue.add((row)*n + col-1);
                            }
                        }
                    }
                }
            }
            return count;
        }
    }

    /**
     * third time
     */
    class Solution3 {
        public int numIslands(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int res = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == '1') {
                        dfs(grid, i, j);
                        res++;
                    }
                }
            }
            return res;
        }

        private void dfs(char[][] grid, int m, int n) {
            if(m >= grid.length || n >= grid[0].length || m < 0 || n < 0 || grid[m][n] == '0') {
                return;
            }
            grid[m][n] = '0';
            dfs(grid, m - 1, n);
            dfs(grid, m + 1, n);
            dfs(grid, m, n - 1);
            dfs(grid, m, n + 1);
            return;
        }
    }
}
