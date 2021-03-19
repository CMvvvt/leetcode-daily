public class P55_jumpGames {
    class Solution {
        public boolean canJump(int[] nums) {
            int length = nums.length;
            boolean[] dp = new boolean[length];
            dp[0] = true;
            for(int i = 1; i < length; i++){
                for(int j = 1; j <= i; j++) {
                    if(dp[i-j] && nums[i-j] >= j) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[length-1];
        }
    }
}
