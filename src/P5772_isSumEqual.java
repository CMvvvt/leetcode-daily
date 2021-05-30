public class P5772_isSumEqual {

    class Solution {
        public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
            return calculate(firstWord) + calculate(secondWord) == calculate(targetWord);
        }
        private int calculate(String word) {
            int n = word.length();
            int res = 0;
            for(int i = 0; i< n; i++) {
                int val = (int) (word.charAt(i) - 'a' );
                res = res*10 + val;
            }
            return res;
        }
    }
}
