public class P5788_largestOddNumberInString {
    class Solution {
        public String largestOddNumber(String num) {
            int n = num.length()-1;
            for(int i = n; i >= 0; i--) {
                int val = num.charAt(i) - '0';
                if(val % 2 != 0) {
                    return num.substring(0, i+1);
                }
            }
            return new String("");
        }
    }
}
