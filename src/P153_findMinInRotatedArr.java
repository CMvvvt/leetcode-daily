public class P153_findMinInRotatedArr {
    class Solution {
        public int findMin(int[] nums) {
            int n = nums.length;
            if(n == 1) return nums[0];
            int low = 0, high = n - 1;
            while(low < high) {
                int mid = low + (high-low)/2;
                if(nums[mid] < nums[high]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return nums[low];
        }
    }
}
