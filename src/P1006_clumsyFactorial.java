public class P1006_clumsyFactorial {
    class Solution {
        public int clumsy(int N) {
            if(N == 1) {
                return 1;
            }
            if(N == 2) {
                return 2;
            }
            int res = N;
            for(int i = 0; i < N-1; i++) {
                switch(i % 4) {
                    case 0: {
                        if(i == 0) {
                            res = N * (N-1) / (N-2);
                            break;
                        }
                        if(i == N - 2){
                            res -= ((N-i) * (N-i-1));
                            break;
                        }
                        res -= ((N-i) * (N-i-1) / (N-i-2));
                        break;
                    }
                    case 2: {
                        res += (N-i-1);
                        break;
                    }
                    case 3: {
                        if(N - i == 2) {
                            res -= (N-i-1);
                        }
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
            return res;
        }
    }
}
