public class P139_wordBreak {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet(wordDict);
            int len = s.length();
            boolean[] dp = new boolean[len+1];
            dp[0] = true;
            for(int i = 1; i <= len; i++) {
                for(int j = 0; j < i; j++) {
                    if(dp[j] && set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[len];
        }
    }
}
