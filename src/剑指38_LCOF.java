public class 剑指38_LCOF {
    class Solution {
        private List<String> list;
        private boolean[] visited;
        public String[] permutation(String s) {
            int n = s.length();
            list = new ArrayList<>();
            visited = new boolean[n];
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            StringBuffer str = new StringBuffer();
            backtrack(arr, 0, n, str);

            int size = list.size();
            String[] res = new String[size];
            for(int i = 0; i < size; i++) {
                res[i] = list.get(i);
            }
            return res;
        }

        private void backtrack(char[] arr, int i, int n, StringBuffer str) {
            if(i == n) {
                list.add(str.toString());
            }
            for(int j = 0; j < n; j++) {
                if(visited[j] || (j > 0 && (!visited[j-1]) && arr[j] == arr[j-1])) {
                    continue;
                }
                visited[j] = true;
                str.append(arr[j]);
                backtrack(arr, i+1, n, str);
                str.deleteCharAt(str.length() - 1);
                visited[j] = false;
            }
        }
    }
}
