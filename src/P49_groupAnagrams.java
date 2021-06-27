import java.util.*;

public class P49_groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    /**
     * extremely bad approach
     */
    class Solution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> res = new ArrayList<>();
            int n = strs.length;
            if(n == 0) return res;
            boolean[] visited = new boolean[n];

            for(int i = 0; i < n; i++) {
                if(visited[i]) continue;
                visited[i] = true;
                List<String> list = new ArrayList<>();
                list.add(strs[i]);

                int length = strs[i].length();
                for(int j = i + 1; j < n; j++) {
                    if(strs[j].length() != length || visited[j]) {
                        continue;
                    }
                    if(isAnagram(strs[i], strs[j])) {
                        visited[j] = true;
                        list.add(strs[j]);
                    }
                }
                res.add(list);
            }
            return res;
        }

        private boolean isAnagram(String str1, String str2) {
            char[] ch1 = str1.toCharArray();
            char[] ch2 = str2.toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            String s1 = String.valueOf(ch1);
            String s2 = String.valueOf(ch2);
            return s1.equals(s2);

        }
    }

    /**
     * Categorized by Count
     */
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) return new ArrayList();
            Map<String, List> ans = new HashMap<String, List>();
            int[] count = new int[26];
            for (String s : strs) {
                Arrays.fill(count, 0);
                for (char c : s.toCharArray()) count[c - 'a']++;

                StringBuilder sb = new StringBuilder("");
                for (int i = 0; i < 26; i++) {
                    sb.append('#');
                    sb.append(count[i]);
                }
                String key = sb.toString();
                if (!ans.containsKey(key)) ans.put(key, new ArrayList());
                ans.get(key).add(s);
            }
            return new ArrayList(ans.values());
        }
    }
}
