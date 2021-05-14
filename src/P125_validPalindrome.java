public class P125_validPalindrome {
    class Solution {
        public boolean isPalindrome(String s) {
            String ss = s.toLowerCase();
            char[] chars = ss.toCharArray();
            int n = chars.length;
            int low = 0;
            int high = n - 1;
            while(low < high) {
                char lowVal = chars[low];
                char highVal = chars[high];
                if(!Character.isLetterOrDigit(lowVal)) {
                    low++;
                    continue;
                }
                if(!Character.isLetterOrDigit(highVal)) {
                    high--;
                    continue;
                }
                if(lowVal == highVal) {
                    low++;
                    high--;
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
