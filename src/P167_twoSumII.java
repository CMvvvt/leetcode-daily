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
    class Solution2 {
        public int[] twoSum(int[] numbers, int target) {
            int n = numbers.length;
            for(int i = 0; i < n-1; i++) {
                int val1 = numbers[i];
                for(int j = i+1; j < n; j++) {
                    int val2 = numbers[j];
                    if(val1 + val2 > target) break;
                    if(val1 + val2 == target) {
                        return new int[]{i+1, j+1};
                    }
                }
            }
            return new int[]{1,1};
        }
    }

    class Solution3 {
        public int[] twoSum(int[] numbers, int target) {
            int n = numbers.length;
            for(int i = 0; i < n; i++) {
                int low = i+1, high = n-1;
                while(low <= high) {
                    int mid = (high + low) / 2;
                    if(numbers[mid] + numbers[i] == target) {
                        return new int[]{i+1, mid+1};
                    }
                    if(numbers[i] + numbers[mid] > target) {
                        high = mid-1;
                        continue;
                    }
                    low = mid+1;
                }
            }
            return new int[]{-1, -1};
        }
    }
}
