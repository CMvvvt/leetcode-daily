public class P1738_findKthLargestXORCoordinateValue {
    class Solution {
        public int kthLargestValue(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length;
            int[][] dp = new int[m+1][n+1];
            List<Integer> res = new ArrayList<>();
            for(int i = 1; i <= m; i++) {
                for(int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i-1][j-1] ^ dp[i-1][j] ^ dp[i][j-1] ^ matrix[i-1][j-1];
                    res.add(dp[i][j]);
                }
            }
            Collections.sort(res, new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return b-a;
                }
            });
            return res.get(k-1);
        }
    }
}
