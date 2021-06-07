public class P494_targetSum {
    class Solution {
        private int count = 0;
        public int findTargetSumWays(int[] nums, int target) {
            backtrack(nums, target, 0, 0);
            return count;
        }
        private void backtrack(int[] nums, int target, int start, int sum) {
            if(start == nums.length) {
                if(sum == target) {
                    count++;
                }
            } else {
                backtrack(nums, target, start+1, sum+nums[start]);
                backtrack(nums, target, start+1, sum-nums[start]);
            }
        }
    }

    class Solution2 {
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for(int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            int diff = sum - target;
            if(diff < 0 || diff % 2 != 0) {
                return 0;
            }
            int n = nums.length, neg = diff / 2;
            int[][] dp = new int[n+1][neg+1];
            dp[0][0] = 1;
            for(int i = 1; i <= n; i++) {
                int num = nums[i-1];
                for(int j = 0; j <= neg; j++) {
                    dp[i][j] = dp[i-1][j];
                    if(j >= num) {
                        dp[i][j] = dp[i][j] + dp[i-1][j-num];
                    }
                }
            }
            return dp[n][neg];
        }
    }
}
