public class P204_countPrimes {
    class Solution {
        public int countPrimes(int n) {
            int[] primes = new int[n];
            Arrays.fill(primes, 1);
            int count = 0;
            for(int i = 2; i < n; i++) {
                if(primes[i] == 1) {
                    count++;
                }
                if((long)i * i < n) {
                    for(int j = i * i; j < n; j += i) {
                        primes[j] = 0;
                    }
                }
            }
            return count;

        }
    }
}
