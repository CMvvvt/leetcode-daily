public class P523_continuousSubarraySum {
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            int length = nums.length;
            if(length < 2) return false;
            Map<Integer, Integer> map = new HashMap<>();
            int remainder = 0;
            map.put(0,-1);
            for(int i = 0; i < length; i++) {
                remainder = (remainder + nums[i]) % k;
                if(map.containsKey(remainder)) {
                    int index = map.get(remainder);
                    if(i - index >= 2) {
                        return true;
                    }
                } else {
                    map.put(remainder, i);
                }
            }
            return false;
        }
    }

    class Solution2 {
        public boolean checkSubarraySum(int[] nums, int k) {
            int length = nums.length;
            if(length < 2) return false;
            int[] sum = new int[length+1];
            sum[0] = nums[0];

            for(int i = 1; i <= length; i++) {
                sum[i] = sum[i-1] + nums[i-1];
            }
            Set<Integer> set = new HashSet<>();
            for(int i = 2; i <= length; i++) {
                set.add(sum[i-2] % k);
                if(set.contains(sum[i] % k)) {
                    return true;
                }
            }
            return false;

        }
    }
}
