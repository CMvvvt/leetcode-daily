public class P69_sqrt {
    class Solution {
        public int mySqrt(int x) {
            return (int )Math.floor(Math.sqrt(x));
        }
    }
//    method 2
public int mySqrt(int x) {
    int l = 0, r = x, ans = 0;
    while(l <= r) {
        int mid = l + (r-l) / 2;
        if((long)mid*mid <= x) {
            ans = mid;
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }
    return ans;
}
}
