public class P50_pow {
    class Solution {
        private double recursivePow(double x, long N){
            if(N == 0){
                return 1.0;
            }
            double y = recursivePow(x, N/2);
            return N % 2 == 0 ? y * y : y * y * x;
        }

        public double myPow(double x, int n) {
            long N = n;
            return N >= 0 ? recursivePow(x, N) : 1.0/recursivePow(x, -N);
        }
    }
}
