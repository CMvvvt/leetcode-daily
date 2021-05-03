public class P7_invert {
    public int reverse(int x) {
        int ans = 0;
        while(x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = 10 * ans + pop;
            x = x/ 10;
        }
        return ans;
    }
    class Solution {
        public int reverse(int x) {
            int res = 0;
            while(x != 0) {
                int tmp = x % 10;
                if((res > Integer.MAX_VALUE/10) || (res == Integer.MAX_VALUE/10 && tmp > Integer.MAX_VALUE%10)) {
                    return 0;
                }
                if((res < Integer.MIN_VALUE/10) || (res == Integer.MIN_VALUE/10 && tmp < Integer.MIN_VALUE%10)) {
                    return 0;
                }
                res = res*10 + tmp;
                x /= 10;
            }
            return res;
        }
    }
}
