public class P5746_getMinDistance {
    class Solution {
        public int getMinDistance(int[] nums, int target, int start) {
            int res = Integer.MAX_VALUE;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == target) {
                    int abs = Math.abs(i - start);
                    if(abs < res) res = abs;
                }
            }
            return res;
        }
    }
}
