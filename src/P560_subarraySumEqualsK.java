public class P560_subarraySumEqualsK {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            for(int i = 0; i < nums.length; i++) {
                int sum = 0;
                for(int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    if(sum == k) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    /**
     *  前缀和 approach
     */
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0, pre = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0,1);
            for(int num: nums) {
                pre += num;
                if(map.containsKey(pre-k)) {
                    count += map.get(pre-k);
                }
                map.put(pre, map.getOrDefault(pre, 0) + 1);
            }
            return count;
        }
    }
}
