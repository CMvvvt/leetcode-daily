public class P486_predictTheWinner {
    class Solution {
        public boolean PredictTheWinner(int[] nums) {
            return total(nums, 0, nums.length-1, 1) >= 0;
        }
        private int total(int[] nums, int start, int end, int turn) {
            if(start == end) return nums[start]*turn;
            int numStart = nums[start]*turn + total(nums, start+1, end, -turn);
            int numEnd = nums[end]*turn + total(nums, start, end-1, -turn);
            return turn > 0 ? Math.max(numEnd, numStart) : Math.min(numStart, numEnd);
        }
    }

    /**
     * dp method
     *
     */
    class Solution2 {
        public boolean PredictTheWinner(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n][n];
            for(int i = 0; i < n; i++) {
                dp[i][i] = nums[i];
            }
            for(int i = n - 2; i >= 0; i--) {
                for(int j = i + 1; j < n; j++) {
                    dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
                }
            }
            return dp[0][n-1] >= 0;
        }
    }
}
