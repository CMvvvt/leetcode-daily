public class P3_longestSubstringWithoutRepeating {
    class Solution1 {
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

    /**
     * sliding window method added
     *
     */
    class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            char[] chars = new char[128];

            int left = 0;
            int right = 0;
            int res = 0;

            while(right < s.length()) {
                char r = s.charAt(right);
                chars[r]++;

                while(chars[r] > 1) {
                    char l = s.charAt(left);
                    chars[l]--;
                    left++;
                }

                res = Math.max(res, right - left + 1);
                right++;
            }
            return res;
        }
    }
}
