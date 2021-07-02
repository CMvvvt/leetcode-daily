public class P819_mostCommonWord {
    class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            paragraph += "?";
            Set<String> bannedSet = new HashSet<>();
            for(String word: banned) {
                bannedSet.add(word);
            }
            HashMap<String, Integer> count = new HashMap<>();
            String ans = "";
            int ansFreq = 0;
            StringBuilder word = new StringBuilder();
            for(char c: paragraph.toCharArray()) {
                if(Character.isLetter(c)) {
                    word.append(Character.toLowerCase(c));
                } else if(word.length() > 0) {
                    String finalWord = word.toString();
                    if(! bannedSet.contains(finalWord)) {
                        count.put(finalWord, count.getOrDefault(finalWord, 0) + 1);
                        if(count.get(finalWord) > ansFreq) {
                            ansFreq = count.get(finalWord);
                            ans = finalWord;
                        }
                    }
                    word = new StringBuilder();
                }
            }
            return ans;
        }
    }
}
