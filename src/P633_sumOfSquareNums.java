public class P633_sumOfSquareNums {
    class Solution {
        public boolean judgeSquareSum(int c) {
            for(long a = 0; a*a <= c; a++) {
                double b = Math.sqrt(c - a*a);
                if(b == (int)b) {
                    return true;
                }
            }
            return false;
        }
    }
    class Solution2 {
        public boolean judgeSquareSum(int c) {
            long a = 0;
            long b = (long) Math.sqrt(c);
            while(a <= b) {
                long sum = a*a + b*b;
                if(sum == c) {
                    return true;
                } else if(sum < c) {
                    a++;
                } else {
                    b--;
                }
            }
            return false;
        }
    }
}
