public class P1239_maxLenOfaConcatenatedStringWithUniqueChars {
    class Solution {
        int ans = 0;
        public int maxLength(List<String> arr) {
            List<Integer> masks = new ArrayList<>();
            for(String s: arr) {
                int mask = 0;
                for(int i = 0; i < s.length(); i++) {
                    int ch = s.charAt(i) - 'a';
                    if(((mask >> ch) & 1) != 0) {
                        mask = 0;
                        break;
                    }
                    mask = mask | (1 << ch);
                }
                if(mask > 0) masks.add(mask);
            }
            backtrace(masks, 0, 0);
            return ans;
        }

        private void backtrace(List<Integer> masks, int pos, int mask) {
            if(pos == masks.size()) {
                ans = Math.max(ans, Integer.bitCount(mask));
                return;
            }
            if((masks.get(pos) & mask) == 0) {
                backtrace(masks, pos+1, mask | masks.get(pos));
            }
            backtrace(masks, pos+1, mask);
        }
    }
}
