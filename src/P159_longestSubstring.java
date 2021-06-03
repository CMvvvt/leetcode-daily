public class P159_longestSubstring {
    class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            int n = s.length();
            if(n < 3) return n;
            int left = 0, right = 0;
            Map<Character, Integer> map = new HashMap<>();
            int max = 2;
            while(right < n) {
                if(map.size() < 3) {
                    map.put(s.charAt(right), right++);
                }
                if(map.size() == 3) {
                    int index = Collections.min(map.values());
                    map.remove(s.charAt(index));
                    left = index + 1;
                }
                max = Math.max(max, right-left);
            }
            return max;
        }
    }
}
