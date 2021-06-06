public class P187_repeatedDNASequences {
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> res = new ArrayList<>();
            int len = s.length();
            if(len <= 10) return res;
            Map<String, Boolean> map = new HashMap<>();
            for(int i = 0; i <= len-10; i++) {
                String str = i == len-10? s.substring(i): s.substring(i, i+10);
                if(map.containsKey(str)) {
                    if(map.get(str)) {
                        res.add(str);
                        map.put(str, false);
                    }
                    continue;
                }
                map.put(str, true);
            }
            return res;
        }
    }
    class Solution2 {
        public List<String> findRepeatedDnaSequences(String s) {
            int L = 10;
            Set<String> seen = new HashSet<>(), output = new HashSet<>();

            for(int i = 0; i < s.length() - L + 1; i++) {
                String str = s.substring(i, i+10);
                if(seen.contains(str)) {
                    output.add(str);
                } else {
                    seen.add(str);
                }
            }
            return new ArrayList<>(output);
        }
    }
}
