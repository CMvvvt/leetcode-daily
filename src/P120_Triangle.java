public class P120_Triangle {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int size = triangle.size();
            if(size == 1) return triangle.get(0).get(0);
            int[][] dp = new int[size][size];
            for(int i = 0; i < size; i++) {
                dp[size-1][i] = triangle.get(size-1).get(i);
            }
            for(int i = size-2; i >= 0; i--) {
                for(int j = 0; j <= i; j++) {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
                }
            }
            return dp[0][0];
        }
    }
}
