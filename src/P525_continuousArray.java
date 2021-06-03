public class P525_continuousArray {
    class Solution {
        public int findMaxLength(int[] nums) {
            int maxLength = 0;
            Map<Integer, Integer> map = new HashMap<>();
            int counter = 0;
            map.put(counter, -1);
            int n = nums.length;
            for(int i = 0; i < n; i++) {
                int num = nums[i];
                if(num == 1) {
                    counter++;
                } else {
                    counter--;
                }
                if(map.containsKey(counter)) {
                    int index = map.get(counter);
                    maxLength = Math.max(maxLength, i - index);
                } else {
                    map.put(counter, i);
                }
            }
            return maxLength;
        }
    }
}
