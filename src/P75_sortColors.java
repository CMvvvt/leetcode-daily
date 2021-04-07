public class P75_sortColors {
    class Solution {
        public void sortColors(int[] nums) {
            int n = nums.length;
            if(n == 1 || n == 0) return;
            int start = 0, end = n-1, index = 0;
            while(index <= end && start < end) {
                if(nums[index] == 0) {
                    nums[index] = nums[start];
                    nums[start] = 0;
                    start++;
                    index++;
                } else if(nums[index] == 2) {
                    nums[index] = nums[end];
                    nums[end] = 2;
                    end--;
                } else {
                    index++;
                }
            }

        }
    }
}
