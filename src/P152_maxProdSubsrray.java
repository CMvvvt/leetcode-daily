public class P152_maxProdSubsrray {
    class Solution {
        public int maxProduct(int[] nums) {
            int len = nums.length;
            int[] max = new int[len];
            int[] min = new int[len];
            max[0] = nums[0];
            min[0] = nums[0];
            for(int i = 1; i < len; i++) {
                max[i] = Math.max(Math.max(max[i-1] * nums[i], min[i-1] * nums[i]), nums[i]);
                min[i] = Math.min(Math.min(max[i-1] * nums[i], min[i-1] * nums[i]), nums[i]);
            }
            int res = nums[0];
            for(int i = 0; i < len; i++) {
                if(max[i] >= res) {
                    res = max[i];
                }
            }
            return res;
        }
    }
}
