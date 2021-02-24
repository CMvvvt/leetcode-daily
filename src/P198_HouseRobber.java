public class P198_HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int N = nums.length;
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[N];
    }
}
