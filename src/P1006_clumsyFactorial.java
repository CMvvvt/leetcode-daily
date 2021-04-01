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
//    method 2
    public int clumsy1(int N) {
        if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else if (N == 3) {
            return 6;
        } else if (N == 4) {
            return 7;
        }

        if (N % 4 == 0) {
            return N + 1;
        } else if (N % 4 <= 2) {
            return N + 2;
        } else {
            return N - 1;
        }
    }
// method 3
    public int clumsy2(int N) {
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(N);
        N--;
        int index = 0;
        while(N > 0) {
            switch(index % 4) {
                case 0: {
                    stack.push(stack.pop() * N);
                    break;
                }
                case 1: {
                    stack.push(stack.pop() / N);
                    break;
                }
                case 2: {
                    stack.push(N);
                    break;
                }
                case 3: {
                    stack.push(-N);
                    break;
                }
            }
            index++;
            N--;
        }
        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
