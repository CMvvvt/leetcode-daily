public class P268_missingNumber {
    class Solution {
        public int missingNumber(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            if(nums[0] != 0) return 0;
            if(n == 2) return nums[1] == 1? 2: 1;
            for(int i = 1; i < n; i++) {
                if(nums[i] - nums[i-1] != 1) return nums[i]-1;
            }
            return n;
        }
    }

    /**
     * HashSet approach
     */
    class Solution2 {
        public int missingNumber(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }
            for(int i = 0; i <= nums.length; i++) {
                if(!set.contains(i)) return i;
            }
            return 0;
        }
    }
}
