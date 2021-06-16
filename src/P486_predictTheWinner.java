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
}
