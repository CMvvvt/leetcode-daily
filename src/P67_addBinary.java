public class P67_addBinary {
    class Solution {
        public String addBinary(String a, String b) {
            StringBuffer ans = new StringBuffer();
            int n = Math.max(a.length(), b.length());
            int carry = 0;
            for(int i = 0; i < n; i++) {
                carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
                carry += i < b.length() ? (b.charAt(b.length() - 1 -i) - '0') : 0;
                ans.append((char) (carry % 2 + '0'));
                carry /= 2;
            }
            if(carry > 0) {
                ans.append('1');
            }
            ans.reverse();
            return ans.toString();
        }
    }
}
