public class P169_majorityElement {
    class Solution {
        public int majorityElement(int[] nums) {
            int n = nums.length;
            Map<Integer,Integer> majorityMap = new HashMap<>();
            for(int i = 0; i < n; i++) {
                majorityMap.put(nums[i], majorityMap.getOrDefault(nums[i], 0) + 1);
                if(majorityMap.get(nums[i]) > n/2) {
                    return nums[i];
                }
            }
            return -1;
        }
    }
    class Solution2 {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length/2];
        }
    }
}
