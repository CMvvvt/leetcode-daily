public class P930_binarySubarraysWithSum {class Solution {
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

    class Solution2 {
        public int numSubarraysWithSum(int[] nums, int goal) {
            int sum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int res = 0;
            for(int num: nums) {
                sum += num;
                if(map.containsKey(sum - goal)) {
                    res += map.get(sum-goal);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return res;
        }
    }
}

}
