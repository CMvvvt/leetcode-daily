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

    /**
     * bucket sort
     */
    class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            int maxFreq = 0;
            int length = s.length();
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                int frequency = map.getOrDefault(c, 0) + 1;
                map.put(c, frequency);
                maxFreq = Math.max(maxFreq, frequency);
            }
            StringBuffer[] buckets = new StringBuffer[maxFreq + 1];
            for (int i = 0; i <= maxFreq; i++) {
                buckets[i] = new StringBuffer();
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                char c = entry.getKey();
                int frequency = entry.getValue();
                buckets[frequency].append(c);
            }
            StringBuffer sb = new StringBuffer();
            for (int i = maxFreq; i > 0; i--) {
                StringBuffer bucket = buckets[i];
                int size = bucket.length();
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < i; k++) {
                        sb.append(bucket.charAt(j));
                    }
                }
            }
            return sb.toString();
        }
    }


}
