public class P451_sortCharsByFrequency {
    /**
     * HashMap approach
     */
    class Solution1 {
        public String frequencySort(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for(char ch: s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            List<Character> list = new ArrayList<>(map.keySet());
            Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
            StringBuilder ans = new StringBuilder();
            for(int i = 0; i < list.size(); i++) {
                char ch = list.get(i);
                int freq = map.get(ch);
                for(int j = 0 ; j < freq; j++) {
                    ans.append(ch);
                }
            }
            return ans.toString();
        }
    }
}
