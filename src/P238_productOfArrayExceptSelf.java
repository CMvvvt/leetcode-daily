public class P238_productOfArrayExceptSelf {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] L = new int[n];
            int[] R = new int[n];
            L[0] = 1;
            R[n-1] = 1;
            for(int i = 1; i < n; i++) {
                L[i] = L[i-1] * nums[i-1];
            }
            for(int j = n - 2; j >= 0; j--) {
                R[j] = R[j+1] * nums[j+1];
            }
            for(int i = 0; i < n; i++) {
                nums[i] = L[i] * R[i];
            }
            return nums;
        }
    }
}
