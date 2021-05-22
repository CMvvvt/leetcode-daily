public class P31_palindromePartition {
    class Solution {
        public List<List<String>> partition(String s) {
            int len = s.length();
            List<List<String>> res = new ArrayList<>();
            if(len == 0) return res;
            Deque<String> stack = new ArrayDeque<>();
            char[] arr = s.toCharArray();
            dfs(res, arr, 0, len, stack);
            return res;
        }

        private boolean isPalindrome(char[] word, int low, int high) {
            while(low < high) {
                if(word[low] != word[high]) return false;
                low++;
                high--;
            }
            return true;
        }

        private void dfs(List<List<String>> res, char[] arr, int index, int len, Deque<String> path) {
            if(index == len) {
                res.add(new ArrayList<>(path));
                return;
            }
            for(int i = index; i < len; i++) {
                if(! isPalindrome(arr, index, i)) {
                    continue;
                }
                path.addLast(new String(arr, index, i+1-index));
                dfs(res,arr, i+1, len, path);
                path.removeLast();
            }
        }
    }

}
