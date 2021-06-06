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
}
