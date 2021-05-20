public class P692_mostKFrequentWords {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            List<String> res = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();
            for(int i = 0; i < words.length; i++) {
                map.put(words[i], map.getOrDefault(words[i], 0)+1);
            }
            for(Map.Entry<String, Integer> entry: map.entrySet()) {
                res.add(entry.getKey());
            }
            Collections.sort(res, new Comparator<String>() {
                public int compare(String word1, String word2) {
                    return map.get(word1) == map.get(word2) ? word1.compareTo(word2) : map.get(word2) - map.get(word1);
                }
            });
            return res.subList(0, k);

        }
    }
}
