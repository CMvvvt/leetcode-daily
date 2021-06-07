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
}
