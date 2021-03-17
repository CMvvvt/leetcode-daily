public class P55_maxSubarray {
    //贪心算法
    class Solution {
        public int maxSubArray(int[] nums) {
            if(nums.length == 1) {
                return nums[0];
            }
            int ans = nums[0];
            int sum = 0;
            for(int i = 0; i < nums.length; i++){
                if(sum > 0){
                    sum += nums[i];
                } else {
                    sum = nums[i];
                }
                ans = Math.max(ans, sum);
            }
            return ans;
        }
    }
//    动态规划
//    class Solution {
//        public int maxSubArray(int[] nums) {
//            int[] dp = new int[nums.length];
//            dp[0] = nums[0];
//            int ans = dp[0];
//            for(int i = 1; i < nums.length; i++){
//                dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
//                ans = Math.max(dp[i], ans);
//            }
//            return ans;
//        }
//    }
}
