public class P167_twoSumII {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int n = numbers.length;
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                int val = numbers[i];
                if(map.containsKey(target-val)) return new int[]{map.get(target-val), i+1};
                map.put(numbers[i], i+1);
            }
            return new int[]{0,0};
        }
    }
}
