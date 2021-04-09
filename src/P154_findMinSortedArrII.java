public class P154_findMinSortedArrII {
    class Solution {
        public int findMin(int[] nums) {
            int n = nums.length;
            int low = 0, high = n - 1;
            while(low < high) {
                int mid = low + (high-low)/2;
                if(nums[mid] == nums[low] && nums[mid] == nums[high]) {
                    low++;
                    high--;
                } else if((nums[mid] <= nums[high] && nums[mid] <= nums[low]) || (nums[mid] <= nums[high] && nums[mid] >= nums[low])) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return nums[low];
        }
    }
}
