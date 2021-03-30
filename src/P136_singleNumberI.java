public class P136_singleNumberI {
    class Solution {
        public int singleNumber(int[] nums) {
            int ans = nums[0];
            if(nums.length > 1) {
                for(int i = 1; i < nums.length; i++) {
                    ans ^= nums[i];
                }
            }
            return ans;
        }
    }
}
