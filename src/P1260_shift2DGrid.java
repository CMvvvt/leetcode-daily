public class P1260_shift2DGrid {
    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            int m = grid.length, n = grid[0].length;
            k = k % (m * n);
            int index = m*n - k;
            List<List<Integer>> res = new ArrayList<>();
            for(int i = 0; i < m; i++) {
                List<Integer> list = new ArrayList<>();
                for(int j = 0; j < n; j++) {
                    list.add(getValue(grid, index, m, n));
                    index = (index+1)%(m*n);
                }
                res.add(new ArrayList(list));
            }
            return res;
        }
        private int getValue(int[][] grid, int k, int m, int n) {
            if(k == m * n) return grid[0][0];
            int i = k / n;
            int j = k % n;
            return grid[i][j];
        }
    }
}
