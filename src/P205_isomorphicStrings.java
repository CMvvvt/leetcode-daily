public class P205_isomorphicStrings {
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> s2t = new HashMap<>();
            Map<Character, Character> t2s = new HashMap<>();
            for(int i = 0; i < s.length(); i++) {
                char a = s.charAt(i);
                char b = t.charAt(i);
                if( (s2t.containsKey(a) && s2t.get(a) != b) || (t2s.containsKey(b) && t2s.get(b) != a) ){
                    return false;
                }
                s2t.put(a,b);
                t2s.put(b,a);
            }
            return true;
        }
    }
}
