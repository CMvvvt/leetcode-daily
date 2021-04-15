import java.lang.management.MemoryType;

public class P213_HouseRobber2 {
    public int rob_method1(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int N = nums.length;
        int[] dp  = new int[N];

        // situation 1: not rob head
        dp[0] = 0;
        dp[1] = nums[1];
        for(int i = 2; i <= N - 1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        int res1 = dp[N - 1];

        //situation 2: not rob tail
        dp[1] = nums[0];
        for(int j = 2; j <= N - 1; j++) {
            dp[j] = Math.max(dp[j-1], dp[j-2] + nums[j-1]);
        }
        int res2= dp[N - 1];
        return Math.max(res1, res2);
    }
    // new method
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if(n == 1) return nums[0];
            if(n == 2) return Math.max(nums[0],nums[1]);
            int[] dp = new int[n];
            // 不偷第一家
            int res1 = 0;
            int res2 = 0;
            dp[0] = 0;
            dp[1] = nums[1];
            for(int i = 2; i < n; i++) {
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
            res1 = dp[n-1];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0],nums[1]);
            for(int i = 2; i < n-1; i++) {
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
            res2 = dp[n-2];
            return Math.max(res1,res2);
        }
    }
}
