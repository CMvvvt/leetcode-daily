public class P387_firstUniqueCharInAString {
    class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0)+1);
            }
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(map.get(ch) == 1) return i;
            }
            return -1;
        }
    }
    /**
     * HashMap stores is or not
     */
    class Solution {
        public int firstUniqChar(String s) {
            int n = s.length();
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if(map.containsKey(ch)) {
                    map.put(ch, -1);
                } else {
                    map.put(ch, i);
                }
            }
            int first = n;
            for(Map.Entry<Character, Integer> entry: map.entrySet()) {
                int pos = entry.getValue();
                if(pos != -1 && pos < first) {
                    first = pos;
                }
            }
            return first == n? -1: first;
        }

    }
}
