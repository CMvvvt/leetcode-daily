public class P974_subarraySumsDivisibleByK {
    class Solution {
        public int subarraysDivByK(int[] nums, int k) {
            int count = 0, sum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for(int num: nums) {
                sum += num;
                int mod = (sum % k + k) % k;
                int same = map.getOrDefault(mod, 0);
                count += same;
                map.put(mod, same + 1);

            }
            return count;
        }
    }
}
