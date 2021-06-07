public class P189_rotateArray {
    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            int[] newArray = new int[n];
            for(int i = 0; i < n; i++) {
                newArray[(i+k)%n] = nums[i];
            }
            System.arraycopy(newArray, 0, nums, 0, n);
            return;
        }
    }
}
