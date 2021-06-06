public class P474_onesAndZeroes {
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int len = strs.length;
            int[][][] dp = new int[len+1][m+1][n+1];
            Pair<Integer, Integer> pair;
            for(int i = 1; i <= len; i++) {
                pair = getPair(strs[i-1]);
                int zeroes = pair.getKey();
                int ones = pair.getValue();
                for(int j = 0; j <= m; j++) {
                    for(int k = 0; k <= n; k++) {
                        dp[i][j][k] = dp[i-1][j][k];
                        if(j >= zeroes && k >= ones) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-zeroes][k-ones] + 1);
                        }
                    }
                }
            }
            return dp[len][m][n];
        }
        private Pair<Integer, Integer> getPair(String str) {
            int zeroes = 0, ones = 0;
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '0') {
                    zeroes++;
                } else {
                    ones++;
                }
            }
            return new Pair(zeroes, ones);
        }
    }
}
