public class P3_longestSubstringWithoutRepeating {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int len = s.length();
            if(len < 2) return len;
            int res = 1;
            int gap = 1;
            for(int i = 0; i < len; i++) {
                for(int j = i + gap; j <= len; j++) {
                    if(hasRepeating(s.substring(i,j))) {
                        gap = j - i;
                        break;
                    }
                    res = j - i;
                    gap = j - i;
                }
            }
            return res;
        }
        private boolean hasRepeating(String s) {
            int n = s.length();
            Set<Character> set = new HashSet<>();
            for(int i = 0; i < n; i++) {
                if(set.contains(s.charAt(i))) return true;
                set.add(s.charAt(i));
            }
            return false;
        }
    }
}
