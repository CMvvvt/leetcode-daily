public class P1049_lastStoneWeightII {
    class Solution {
        public int lastStoneWeightII(int[] stones) {
            int n = stones.length;
            int sum = 0;
            for(int num: stones) {
                sum += num;
            }
            int[][] dp = new int[n+1][sum/2+1];
            for(int i = 1; i <= n; i++) {
                for(int j = 0; j <= sum/2; j++) {
                    dp[i][j] = dp[i-1][j];
                    if(stones[i-1] <= j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j - stones[i-1]] + stones[i-1]);
                    }
                }
            }
            return sum-dp[n][sum/2]*2;
        }
    }
}
