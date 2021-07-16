public class Offer53_findTimesOfNumberInSortedArray {
    class Solution {
        public int search(int[] nums, int target) {
            return helper(nums, target) - helper(nums, target-1);
        }

        private int helper(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
}
