public class P76_minimumWindowSubstring {
    class Solution {
        Map<Character, Integer> origin = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int l = -1;
        int r = -1;
        int len = Integer.MAX_VALUE;
        public String minWindow(String s, String t) {
            for(int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                origin.put(c, origin.getOrDefault(c, 0) + 1);
            }
            int left = 0;
            int right = -1;
            while(right < s.length()) {
                right++;
                if(right < s.length() && origin.containsKey(s.charAt(right))) {
                    window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
                }
                while(check() && left <= right) {
                    if(right - left + 1 < len) {
                        l = left;
                        r = right;
                        len = r - l + 1;
                    }
                    if(origin.containsKey(s.charAt(left))) {
                        window.put(s.charAt(left), window.getOrDefault(s.charAt(left), 1) - 1);
                    }
                    left++;
                }
            }
            return r == -1? "" : s.substring(l, r+1);
        }

        private boolean check() {
            for(Map.Entry entry: origin.entrySet()) {
                int times = (int) entry.getValue();
                if(window.getOrDefault(entry.getKey(), 0) < times) {
                    return false;
                }
            }
            return true;
        }
    }
}
