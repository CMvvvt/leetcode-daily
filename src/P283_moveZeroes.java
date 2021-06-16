public class P283_moveZeroes {
    class Solution {
        public void moveZeroes(int[] nums) {
            int k = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == 0) {
                    k++;
                }
            }
            int index = 0;
            for(int i = 0;  i < nums.length; i++) {
                if(nums[i] != 0) nums[index++] = nums[i];
            }
            for(int i = nums.length - k; i < nums.length; i++) {
                nums[i] = 0;
            }
            return;
        }
    }

    class Solution2{
        public void moveZeroes(int[] nums) {
            int n = nums.length, left = 0, right = 0;
            while(right < n) {
                if(nums[right] != 0) {
                    int temp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = temp;
                    left++;
                }
                right++;
            }
            return;
        }
    }
}
